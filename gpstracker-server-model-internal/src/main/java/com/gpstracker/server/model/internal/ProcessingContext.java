package com.gpstracker.server.model.internal;

import org.joda.time.LocalDateTime;

/**
 * The Processing context define and maintains the processing state of a partially request, it should be passed
 * down through each layer of the architecture and updated accordingly.
 */
public class ProcessingContext extends InternalEntity {
    
    /**  */
    private static final long serialVersionUID = 1L;
    /** Indicates if the processing should be executed asynchronously. */
    private boolean useAsynchronousProcessing;
    /** Indicates if the request to process can support callback on the client side. */
    private boolean asynchronousCallbackSupported;
    /** Indicates if the request to process can support callback on the client side. */
    private boolean asynchronousCallbackIssued;
    /** Indicates if the user request is authenticated. */
    private boolean requestAuthenticated;
    /** Indicates the processing stage of the current request processing. */
    private ProcessingStageType processingStage;
    /** The time processing began. */
    private LocalDateTime processingStartTime;
    /** The time processing completed. */
    private LocalDateTime processingCompleteTime;
    
    /**
     * @return the useAsynchronousProcessing
     */
    public boolean isUseAsynchronousProcessing() {
        return useAsynchronousProcessing;
    }
    
    /**
     * @param useAsynchronousProcessing the useAsynchronousProcessing to set
     */
    public void setUseAsynchronousProcessing(final boolean useAsynchronousProcessing) {
        this.useAsynchronousProcessing = useAsynchronousProcessing;
    }
    
    /**
     * @return the asynchronousCallbackSupported
     */
    public boolean isAsynchronousCallbackSupported() {
        return asynchronousCallbackSupported;
    }
    
    /**
     * @param asynchronousCallbackSupported the asynchronousCallbackSupported to set
     */
    public void setAsynchronousCallbackSupported(final boolean asynchronousCallbackSupported) {
        this.asynchronousCallbackSupported = asynchronousCallbackSupported;
    }
    
    /**
     * @return the asynchronousCallbackIssued
     */
    public boolean isAsynchronousCallbackIssued() {
        return asynchronousCallbackIssued;
    }

    /**
     * @param asynchronousCallbackIssued the asynchronousCallbackIssued to set
     */
    public void setAsynchronousCallbackIssued(boolean asynchronousCallbackIssued) {
        this.asynchronousCallbackIssued = asynchronousCallbackIssued;
    }

    /**
     * @return the requestAuthenticated
     */
    public boolean isRequestAuthenticated() {
        return requestAuthenticated;
    }
    
    /**
     * @param requestAuthenticated the requestAuthenticated to set
     */
    public void setRequestAuthenticated(final boolean requestAuthenticated) {
        this.requestAuthenticated = requestAuthenticated;
    }
    
    /**
     * @return the processingStage
     */
    public ProcessingStageType getProcessingStage() {
        return processingStage;
    }
    
    /**
     * @param processingStage the processingStage to set
     */
    public void setProcessingStage(final ProcessingStageType processingStage) {
        this.processingStage = processingStage;
    }

    /**
     * @return the processingStartTime
     */
    public LocalDateTime getProcessingStartTime() {
        return processingStartTime;
    }

    /**
     * @param processingStartTime the processingStartTime to set
     */
    public void setProcessingStartTime(final LocalDateTime processingStartTime) {
        this.processingStartTime = processingStartTime;
    }

    /**
     * @return the processingCompleteTime
     */
    public LocalDateTime getProcessingCompleteTime() {
        return processingCompleteTime;
    }

    /**
     * @param processingCompleteTime the processingCompleteTime to set
     */
    public void setProcessingCompleteTime(final LocalDateTime processingCompleteTime) {
        this.processingCompleteTime = processingCompleteTime;
    }    
}
