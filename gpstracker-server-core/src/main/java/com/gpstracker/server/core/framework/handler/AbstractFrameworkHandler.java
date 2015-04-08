package com.gpstracker.server.core.framework.handler;

import com.gpstracker.server.api.core.InternalFrameworkHandler;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.ProcessingContext;
import com.gpstracker.server.model.internal.mq.InternalMessage;
import com.gpstracker.server.service.mq.api.MessageQueueService;

/**
 * Implementation of abstract framework handler. The framework handlers work on the principle that an application
 * should not have a hard code architecture. They allow for the archecture to be 
 */
public abstract class AbstractFrameworkHandler implements InternalFrameworkHandler {
    
    /** The message queue service. */
    private MessageQueueService mqService;
    /** Destination queue for next asynchronous processing handler. */
    private String nextDistintationQueue;
    /** Next frame handler in the chain. */
    private InternalFrameworkHandler nextFrameworkHandler;
    
    @Override
    public Object handle(final ProcessingContext processingContext, final Object argument) {
        Object result = handleProcessing(argument);
        
        if (nextFrameworkHandler == null) {
            if (result instanceof InternalEntity) {
                throw new RuntimeException("NO HANDLER CONFIGURE FOR PROCESSING INTERNAL MODEL");
            }
            return (ExternalEntity) result;
        }
        
        if (isAsynchronousProcessRequired(processingContext)) {
            invokeNextHandlerAsynchronously(processingContext, (InternalEntity) result);
            return null;
        } else {
            return invokeNextHandlerSynchronously(processingContext, (InternalEntity) result);
        }
    }

    //---------------------------------------------------------------------------------------------
    // Abstract method definitions
    protected abstract Object handleProcessing(final Object argument);
    
    //---------------------------------------------------------------------------------------------
    protected boolean isAsynchronousProcessRequired(final ProcessingContext processingContext) {
        // TODO Auto-generated method stub
        return false;
    }

    protected void invokeNextHandlerAsynchronously(final ProcessingContext processingContext, final InternalEntity argument) {
        mqService.pushMesssage(
                new InternalMessage(null, processingContext, argument),
                getNextDistintationQueue());    
    }
    
    protected Object invokeNextHandlerSynchronously(final ProcessingContext processingContext, InternalEntity argument) {
        return nextFrameworkHandler.handle(processingContext, argument);
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
     * @return the nextFrameworkHandler
     */
    public InternalFrameworkHandler getNextFrameworkHandler() {
        return nextFrameworkHandler;
    }

    /**
     * @param nextFrameworkHandler the nextFrameworkHandler to set
     */
    public void setNextFrameworkHandler(
            InternalFrameworkHandler nextFrameworkHandler) {
        this.nextFrameworkHandler = nextFrameworkHandler;
    }

    /**
     * @return the nextDistintationQueue
     */
    protected String getNextDistintationQueue() {
        return nextDistintationQueue;
    }
    
    /**
     * @param nextDistintationQueue the nextDistintationQueue to set
     */
    public void setNextDistintationQueue(String nextDistintationQueue) {
        this.nextDistintationQueue = nextDistintationQueue;
    }
}
