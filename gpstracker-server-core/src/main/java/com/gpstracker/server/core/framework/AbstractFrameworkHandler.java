package com.gpstracker.server.core.framework;

import com.gpstracker.server.api.core.CallbackResultStore;
import com.gpstracker.server.api.core.InternalFrameworkHandler;
import com.gpstracker.server.api.core.ThroughputMonitor;
import com.gpstracker.server.model.internal.ProcessingContext;
import com.gpstracker.server.model.internal.mq.InternalMessage;
import com.gpstracker.server.service.mq.api.MessageQueueService;

/**
 * Implementation of abstract framework handler. The framework handlers work on the principle that an application
 * should not have a hard code architecture. They allow for the architecture to be 
 */
public abstract class AbstractFrameworkHandler {
    
    /** Destination queue for next asynchronous processing handler. */
    private String nextDestinationQueue;
    /** Throughput monitor to monitor through put. */
    protected ThroughputMonitor throughputMonitor;
    /** The callback result store to store asynchronous processing results. */
    protected CallbackResultStore resultStore;
    /** The message queue service. */
    protected MessageQueueService mqService;    
    /** Next frame handler in the chain. */
    protected InternalFrameworkHandler nextFrameworkHandler;

    //---------------------------------------------------------------------------------------------
    /**
     * Determines if the processing should be executed asynchronously.
     * 
     * @param processingContext the processing context
     * @return true if the processing should be executed asynchronously, false otherwise
     */
    protected boolean isAsynchronousProcessRequired(final ProcessingContext processingContext) {        
        return processingContext.isUseAsynchronousProcessing();
    }

    /**
     * Invokes the next handler in the sequence asynchronously.
     * 
     * @param processingContext the processing context
     * @param argument the input argument for the next handler
     */
    protected void invokeNextHandlerAsynchronously(final ProcessingContext processingContext, final Object argument) {
        InternalMessage message = new InternalMessage(processingContext, argument);
        mqService.pushMesssage(message, getNextDestinationQueue());     
    }
    
    /**
     * Invokes the next handler in the sequence synchronously.
     * 
     * @param processingContext the processing context
     * @param argument the input argument for the next handler
     * @return
     */
    protected Object invokeNextHandlerSynchronously(final ProcessingContext processingContext, final Object argument) {
        return nextFrameworkHandler.handle(processingContext, argument);
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Gets the mqService.
     * 
     * @return the mqService
     */
    public MessageQueueService getMqService() {
        return mqService;
    }

    /**
     * Sets the mqService.
     * 
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
     * Gets the next next destination queue.
     * 
     * @return the nextDistintationQueue
     */
    protected String getNextDestinationQueue() {
        return nextDestinationQueue;
    }
    
    /**
     * Sets the next next destination queue.
     * 
     * @param nextDistintationQueue the nextDestinationQueue to set
     */
    public void setNextDestinationQueue(String nextDestinationQueue) {
        this.nextDestinationQueue = nextDestinationQueue;
    }
    
    /**
     * Gets the throughputMonitor.
     * 
     * @return the throughputMonitor
     */
    public ThroughputMonitor getThroughputMonitor() {
        return throughputMonitor;
    }

    /**
     * Sets the throughputMonitor.
     * 
     * @param throughputMonitor the throughputMonitor to set
     */
    public void setThroughputMonitor(ThroughputMonitor throughputMonitor) {
        this.throughputMonitor = throughputMonitor;
    }

    /**
     * Gets the resultStore.
     * 
     * @return the resultStore
     */
    public CallbackResultStore getResultStore() {
        return resultStore;
    }

    /**
     * Sets the resultStore.
     * 
     * @param resultStore the resultStore to set
     */
    public void setResultStore(CallbackResultStore resultStore) {
        this.resultStore = resultStore;
    }
}
