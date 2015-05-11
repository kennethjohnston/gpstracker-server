package com.gpstracker.server.model.internal;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * The Processing context define and maintains the processing state of a partially request, it should be passed
 * down through each layer of the architecture and updated accordingly.
 */
public class ProcessingContext extends InternalEntity {
    
    /** Serialistion Id. */
    private static final long serialVersionUID = -653508315694905836L;
    /** The unique processing Id. */
    private String processingId;
    /** The related user Id. */
    private String userId;
    /** Indicates if the processing should be executed asynchronously. */
    private boolean useAsynchronousProcessing;
    /** Indicates if the request to process can support callback on the client side. */
    private boolean asynchronousCallbackSupported;
    /** Indicates if the request to process can support callback on the client side. */
    private boolean asynchronousCallbackIssued;
    /** Indicates if the processing has completed. */
    private boolean processingComplete;
    /** Indicates if the processing has completed. */
    private boolean processingCompletedSuccessfully;
    /** Indicates the processing stage of the current request processing. */
    private ProcessingStageType processingStage;
    /** The time processing began. */
    private LocalDateTime processingStartTime;
    /** The time processing completed. */
    private LocalDateTime processingCompleteTime;

    /**
     * Default contructor.
     */
    public ProcessingContext() {

    }

    /**
     * Calculates the processing time in milli-seconds of the current processing has or is taking
     * the time is calculated based on the time between the time the started and either the time
     * the request was completed, or the current time if the process is not yet completed.
     * 
     * @return the processing time taken or is currently taking
     */
    public long calculateProcessingTime() {
        LocalDateTime endTime = null;
        if (processingCompleteTime != null) {
            endTime = processingCompleteTime;
        } else {
            endTime = LocalDateTime.now();
        }

        return new Period(processingStartTime, endTime, PeriodType.millis()).getMillis();
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the processingId
     */
    public String getProcessingId() {
        return processingId;
    }

    /**
     * @param processingId the processingId to set
     */
    public void setProcessingId(final String processingId) {
        this.processingId = processingId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

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
     * @return the processingComplete
     */
    public boolean isProcessingComplete() {
        return processingComplete;
    }

    /**
     * @param processingComplete the processingComplete to set
     */
    public void setProcessingComplete(boolean processingComplete) {
        this.processingComplete = processingComplete;
    }

    /**
     * @return the processingCompletedSuccessfully
     */
    public boolean isProcessingCompletedSuccessfully() {
        return processingCompletedSuccessfully;
    }

    /**
     * @param processingCompletedSuccessfully the processingCompletedSuccessfully to set
     */
    public void setProcessingCompletedSuccessfully(boolean processingCompletedSuccessfully) {
        this.processingCompletedSuccessfully = processingCompletedSuccessfully;
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
