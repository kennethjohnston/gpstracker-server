package com.gpstracker.server.core.framework;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.joda.time.LocalDateTime;

import com.gpstracker.server.api.core.InternalFrameworkHandler;
import com.gpstracker.server.core.model.CallbackProcessingResult;
import com.gpstracker.server.core.model.CallbackProcessingStatusType;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.ProcessingContext;
import com.gpstracker.server.model.internal.mq.InternalMessage;

/**
 * Implementation of abstract framework handler. The framework handlers work on the principle that an application
 * should NOT have a hard code architecture. They allow for the architecture to be flexible, and that the processing
 * flow can be manipulated without code changes through configuration and internal discussion making at runtime.  
 */
public abstract class AbstractInternalFrameworkHandler extends AbstractFrameworkHandler implements InternalFrameworkHandler, MessageListener {
       
    /**
     * Handles the internal framework request.
     * 
     * @param processingContext the processing context
     * @param argument the input argument that is the input for the target invocation
     * @return the result of the invocation
     */
    @Override
    public Object handle(final ProcessingContext processingContext, final Object argument) {        
        Object result = handleProcessing(argument);                
        if (isNextHandlerCallRequired(processingContext, result)) {
            return invokeNextHandler(processingContext, result);            
        } 
        return handleTerminalResult(processingContext, result);
    }
    
    /**
     * Handles a JMS message being received by the listener, this is required to support 
     * the asynchronous processing aspect of the framework handler. To support this,
     * the framework hanlder is required to produce and consume JMS messages.
     * 
     * @param message the jms message received.
     */
    @Override    
    public void onMessage(final Message message) {
        if (message instanceof ObjectMessage) {
            try {
                InternalMessage internalMessage = (InternalMessage) ((ObjectMessage) message).getObject();
                handle(internalMessage.getProcessingContext(), internalMessage.getMessageContent());
            } catch (JMSException ex) {
                throw new IllegalArgumentException("Message must be of type Object with InternalMessage content: ",  ex);
            } catch (Exception e) {
                throw new RuntimeException("Exception occurred during message listener: " + e);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type Object");
        }
    }
    
    //---------------------------------------------------------------------------------------------
    // Abstract method definitions
    /**
     * Handles the business logic processing for the specific unit of work.
     * 
     * @param argument the input argument
     * @return the response from processing
     */
    protected abstract Object handleProcessing(final Object argument);
           
    //---------------------------------------------------------------------------------------------
    /**
     * Determines if the next handler is required to be called.
     * 
     * @param processingContext the processing context
     * @param result the current processing result
     * @return true if the next handler should be called, false other
     */
    protected boolean isNextHandlerCallRequired(final ProcessingContext processingContext, final Object result) {
        return result instanceof InternalEntity && nextFrameworkHandler != null;
    }
    
    /**
     * Invokes/calls the next handler, the method call will handle if the invocation should be
     * asynchronously or synchronously executed.
     * 
     * @param processingContext the processing context
     * @param argument the input for target invocation
     * @return the result of the target invocation
     */
    protected Object invokeNextHandler(final ProcessingContext processingContext, final Object argument) {
        if (isAsynchronousProcessRequired(processingContext)) {
            invokeNextHandlerAsynchronously(processingContext, argument);
            return null;
        } else {
            return invokeNextHandlerSynchronously(processingContext, argument);
        }
    }
    
    /**
     * Handles the terminal (end) processing result, at this point it is expected that all required processing 
     * has been completed. 
     * 
     * @param processingContext the processing context
     * @param result the result of processing
     * @return the end processing result if synchronous processing, null if asynchronous processing
     */
    protected Object handleTerminalResult(final ProcessingContext processingContext, final Object result) {
        if (result instanceof InternalEntity) {
            throw new RuntimeException("NO HANDLER CONFIGURE FOR PROCESSING INTERNAL ENTITY");
        }
        
        try {            
            if (isAsynchronousProcessRequired(processingContext)) {
                CallbackProcessingResult callbackProcessingResult = new CallbackProcessingResult();
                callbackProcessingResult.setId(processingContext.getProcessingId());
                callbackProcessingResult.setUserId(processingContext.getUserId());
                callbackProcessingResult.setResponseResultClassType(result.getClass().getCanonicalName());
                callbackProcessingResult.setResponseResult(result);
                callbackProcessingResult.setStatus(CallbackProcessingStatusType.COMPLETE);
                resultStore.store(callbackProcessingResult);
                return null;
            } else {
                return (ExternalEntity) result;
            } 
        } finally {                
            processingContext.setProcessingCompleteTime(LocalDateTime.now());
            throughputMonitor.notifyRequestCompleted(processingContext);
        }
    }
}
