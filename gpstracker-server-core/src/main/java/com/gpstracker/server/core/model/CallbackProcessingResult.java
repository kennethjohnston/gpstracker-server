package com.gpstracker.server.core.model;

import org.joda.time.DateTime;

/**
 * Core model object that defines the callback processing results.
 */
public class CallbackProcessingResult {
    
    private String id;
    
    private String userId;
    
    private DateTime creationDateTime;
    
    private DateTime expectedCompletionDateTime;
    
    private CallbackProcessingStatusType status;
    
    private String responseResultClassType;
    
    private Object responseResult;
    
    /**
     * Default constructor.
     */
    public CallbackProcessingResult() {
        
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
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
     * @return the creationDateTime
     */
    public DateTime getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * @param creationDateTime the creationDateTime to set
     */
    public void setCreationDateTime(DateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    /**
     * @return the expectedCompletionDateTime
     */
    public DateTime getExpectedCompletionDateTime() {
        return expectedCompletionDateTime;
    }

    /**
     * @param expectedCompletionDateTime the expectedCompletionDateTime to set
     */
    public void setExpectedCompletionDateTime(DateTime expectedCompletionDateTime) {
        this.expectedCompletionDateTime = expectedCompletionDateTime;
    }

    /**
     * @return the status
     */
    public CallbackProcessingStatusType getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(CallbackProcessingStatusType status) {
        this.status = status;
    }

    /**
     * @return the responseResultClassType
     */
    public String getResponseResultClassType() {
        return responseResultClassType;
    }

    /**
     * @param responseResultClassType the responseResultClassType to set
     */
    public void setResponseResultClassType(String responseResultClassType) {
        this.responseResultClassType = responseResultClassType;
    }

    /**
     * @return the responseResult
     */
    public Object getResponseResult() {
        return responseResult;
    }

    /**
     * @param responseResult the responseResult to set
     */
    public void setResponseResult(Object responseResult) {
        this.responseResult = responseResult;
    }
    
    
        
}
