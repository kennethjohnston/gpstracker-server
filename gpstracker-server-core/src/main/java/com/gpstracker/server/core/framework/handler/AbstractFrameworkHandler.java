package com.gpstracker.server.core.framework.handler;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.gpstracker.server.api.core.InternalFrameworkHandler;
import com.gpstracker.server.api.core.ThroughputMonitor;
import com.gpstracker.server.core.monitor.LocalStatefulThroughputMonitor;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.response.CallbackResponse;
import com.gpstracker.server.model.external.response.RawUserResponse;
import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.ProcessingContext;
import com.gpstracker.server.model.internal.mq.InternalMessage;
import com.gpstracker.server.service.mq.api.MessageQueueService;

/**
 * Implementation of abstract framework handler. The framework handlers work on the principle that an application
 * should not have a hard code architecture. They allow for the archecture to be 
 */
public abstract class AbstractFrameworkHandler implements InternalFrameworkHandler, MessageListener {
    
    /** The message queue service. */
    private MessageQueueService mqService;
    /** Destination queue for next asynchronous processing handler. */
    private String nextDistintationQueue;
    /** Next frame handler in the chain. */
    private InternalFrameworkHandler nextFrameworkHandler;
    /** Throughput monitor to monitor through put. */
    private ThroughputMonitor throughputMonitor = LocalStatefulThroughputMonitor.getInstance();
    
    @Override
    public Object handle(final ProcessingContext processingContext, final Object argument) {
        Object result = handleProcessing(argument);
        
        // If an external entity was created then the response is ready to be send back to the user.
        if (result instanceof ExternalEntity) {
            return (ExternalEntity) result;
        }
        
        // If no next handler configured then we have reached the end of the chain,
        // therefore it is expected an external entity should be available.
        if (nextFrameworkHandler == null) {
            if (result instanceof InternalEntity) {
                throw new RuntimeException("NO HANDLER CONFIGURE FOR PROCESSING INTERNAL ENTITY");
            }
            return (ExternalEntity) result;
        }
        
        // Determine if the next stage of
        if (isAsynchronousProcessRequired(processingContext)) {
            Object response = null;
            boolean callBackIssue = processingContext.isAsynchronousCallbackIssued();
            if (callBackIssue == false) {
                processingContext.setAsynchronousCallbackIssued(true);
                response = createCallbackResponse(result);
            }
            invokeNextHandlerAsynchronously(processingContext, (InternalEntity) result);
            return response;
        } else {
            return invokeNextHandlerSynchronously(processingContext, (InternalEntity) result);
        }
    }

    /**
     * 
     */
    @Override
    public void onMessage(final Message message) {
        if (message instanceof ObjectMessage) {
            InternalMessage internalMessage;
            try {
                internalMessage = (InternalMessage)((ObjectMessage)message).getObject();
                ProcessingContext processingContext = internalMessage.getProcessingContext();
                InternalEntity argument = internalMessage.getMessageContent();
                handle(processingContext, argument);
            } catch (JMSException ex) {
                throw new IllegalArgumentException("Message must be of type Object with InternalMessage content: ", ex);
            }            
        } else {
            throw new IllegalArgumentException("Message must be of type Object");
        }
    }
    
    //---------------------------------------------------------------------------------------------
    // Abstract method definitions
    protected abstract Object handleProcessing(final Object argument);
           
    //---------------------------------------------------------------------------------------------
    /**
     * 
     * @param processingContext
     * @return
     */
    protected boolean isAsynchronousProcessRequired(final ProcessingContext processingContext) {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 
     * @param processingContext
     * @param argument
     */
    protected void invokeNextHandlerAsynchronously(final ProcessingContext processingContext, final InternalEntity argument) {
        mqService.pushMesssage(
                new InternalMessage(null, processingContext, argument),
                getNextDistintationQueue());    
    }
    
    /**
     * 
     * @param processingContext
     * @param argument
     * @return
     */
    protected Object invokeNextHandlerSynchronously(final ProcessingContext processingContext, InternalEntity argument) {
        return nextFrameworkHandler.handle(processingContext, argument);
    }
    
    protected Object createCallbackResponse(final Object argument) {
        RawUserResponse response = new RawUserResponse();
        response.setCallBackResponse(createCallback());
        
        return response;
    }
    
    protected CallbackResponse createCallback() {
        return new CallbackResponse(123, 3444, 345345345);
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the mqService
     */
    public MessageQueueService getMqService() {
        return mqService;
    }

    /**
     * @param mqService the mqService to set
     */
    public void setMqService(MessageQueueService mqService) {
        this.mqService = mqService;
    }

    /**
     *  Sets the next framework handler.
     * 
     * @return the nextFrameworkHandler
     */
    public InternalFrameworkHandler getNextFrameworkHandler() {
        return nextFrameworkHandler;
    }

    /**
     * Sets the next framework handler.
     * 
     * @param nextFrameworkHandler the nextFrameworkHandler to set
     */
    public void setNextFrameworkHandler(
            InternalFrameworkHandler nextFrameworkHandler) {
        this.nextFrameworkHandler = nextFrameworkHandler;
    }

    /**
     * Gets the next next distintation queue.
     * 
     * @return the nextDistintationQueue
     */
    protected String getNextDistintationQueue() {
        return nextDistintationQueue;
    }
    
    /**
     * Sets the next next distintation queue.
     * 
     * @param nextDistintationQueue the nextDistintationQueue to set
     */
    public void setNextDistintationQueue(String nextDistintationQueue) {
        this.nextDistintationQueue = nextDistintationQueue;
    }
}
