package com.gpstracker.server.core.framework;

import java.util.UUID;

import org.joda.time.LocalDateTime;

import com.gpstracker.server.api.core.EntryPointFrameworkHandler;
import com.gpstracker.server.core.model.CallbackProcessingResult;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.request.AbstractUserRequest;
import com.gpstracker.server.model.external.response.CallbackResponse;
import com.gpstracker.server.model.internal.ProcessingContext;
import com.gpstracker.server.model.internal.ProcessingStageType;

/**
 * Defines a generic entry point that the internal framework can be accessed.
 */
public class GenericEntryPointFrameworkHandler extends AbstractFrameworkHandler implements EntryPointFrameworkHandler {  
   
    /** Default processing time threshold perform asynchronous processing should be used. */
    private static final long defaultMilliSecondsAlloweBeforeAsynchronousProcessing = 2000;
    /** Max processing time threshold perform asynchronous processing should be used. */
    private long maxMilliSecondsAlloweBeforeAsynchronousProcessing = defaultMilliSecondsAlloweBeforeAsynchronousProcessing;
    /** Allow asynchronous processing. */
    private boolean allowAsynchonousProcessing = true;
    
    /**
     * Handles the processing of a request submitted to the application.
     * 
     * @param argument the input argument
     * @return the result from processing the request, may contains a callback response
     */
    @Override
    public Object handle(final Object argument) {
        ProcessingContext processingContext = createProcessingContext((AbstractUserRequest) argument);
        throughputMonitor.notifyRequestReceived(processingContext);

        if (processingContext.isUseAsynchronousProcessing()) {
            invokeNextHandlerAsynchronously(processingContext, argument);
            processingContext.setAsynchronousCallbackIssued(true);
            return (ExternalEntity) createCallbackResponse(processingContext);
        }
        
        return (ExternalEntity) invokeNextHandlerSynchronously(processingContext, argument);
    }  
    
    /**
     * Handles the processing of a callback request submitted to the application.
     * 
     * @param argument the input argument
     * @return the result from processing the request, may contains a callback response
     */
    @Override
    public Object handleCallback(final Object argument) {        
        ExternalEntity response = null;        
        if (argument instanceof AbstractUserRequest) {
            AbstractUserRequest request = (AbstractUserRequest) argument;
            CallbackProcessingResult callbackResponse = resultStore.get(request.getCallBackToken());
            if (callbackResponse != null) {
                response = (ExternalEntity) callbackResponse.getResponseResult();
            } else {
                response = handleProcessingStillInProgress();
            }
        }

        return response;
    }    

    //---------------------------------------------------------------------------------------------
    /**
     * Creates a processing context that will be used to determine how the application is to be processed.
     * @param request 
     * 
     * @return the processing context associated with the request.
     */
    protected ProcessingContext createProcessingContext(final AbstractUserRequest request) {
        ProcessingContext context = new ProcessingContext();
        context.setProcessingId(UUID.randomUUID().toString());
        context.setAsynchronousCallbackSupported(request.isCallBackAllowed());
        context.setProcessingStartTime(LocalDateTime.now());
        context.setProcessingStage(ProcessingStageType.REQUEST_RECIEVED);
        if (request.getUserIdentifier() != null) {
            context.setUserId(request.getUserIdentifier().getUserId());
        }
        
        if (allowAsynchonousProcessing && request.isCallBackAllowed()) {
            boolean thresholdExceeded = throughputMonitor.getCurrentExpectedProcessingTime() >= maxMilliSecondsAlloweBeforeAsynchronousProcessing;
            context.setUseAsynchronousProcessing(thresholdExceeded);
        }
        
        return context;
    }
    
    /**
     * Handles the event where the client response is still currently being
     * processed.
     * 
     * @return the response to send back to the client.
     */
    protected ExternalEntity handleProcessingStillInProgress() {
        // This is not implemented as part of the current implementation
        // and is outside of the requirements defined for the project.
        // This method is to acknowledge the scenario, and provide an hook
        // method that could be implemented in the future.
        throw new UnsupportedOperationException();
    }
    
    //---------------------------------------------------------------------------------------------
    /**
     * Creates a callback response, the callback response is created with a unique Id and contains
     * the interval time that the client should callback for the response. 
     * 
     * @param processingContext the processing context
     * @return the callback response
     */
    protected CallbackResponse createCallbackResponse(final ProcessingContext processingContext) {
        return new CallbackResponse(
                processingContext.getProcessingId(),
                throughputMonitor.getCurrentExpectedProcessingTime());
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Determines if asynchronous processing is allowed.
     * 
     * @return the allowAsynchonousProcessing
     */
    public boolean isAllowAsynchonousProcessing() {
        return allowAsynchonousProcessing;
    }

    /**
     * Set whether asynchronous processing is allowed.
     * 
     * @param allowAsynchonousProcessing the allowAsynchonousProcessing to set
     */
    public void setAllowAsynchonousProcessing(boolean allowAsynchonousProcessing) {
        this.allowAsynchonousProcessing = allowAsynchonousProcessing;
    }

    /**
     * Sets the max milli-seconds allowed before processing requests asynchronously.
     * 
     * @return the maxMilliSecondsAlloweBeforeAsynchronousProcessing
     */
    public long getMaxMilliSecondsAlloweBeforeAsynchronousProcessing() {
        return maxMilliSecondsAlloweBeforeAsynchronousProcessing;
    }

    /**
     * Gets the max milli-seconds allowed before processing requests asynchronously.
     * 
     * @param maxMilliSecondsAlloweBeforeAsynchronousProcessing the maxMilliSecondsAlloweBeforeAsynchronousProcessing to set
     */
    public void setMaxMilliSecondsAlloweBeforeAsynchronousProcessing(
            long maxMilliSecondsAlloweBeforeAsynchronousProcessing) {
        this.maxMilliSecondsAlloweBeforeAsynchronousProcessing = maxMilliSecondsAlloweBeforeAsynchronousProcessing;
    }
}
