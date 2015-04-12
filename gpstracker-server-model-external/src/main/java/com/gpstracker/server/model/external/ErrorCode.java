package com.gpstracker.server.model.external;

public class ErrorCode {
    
    /** The type of the error. */
    private ErrorCodeType errorType;
    /** Error message. */
    private String errorMessage;
    
    /**
     * Default constructor.
     */
    public ErrorCode() {
        
    }
    
    /**
     * Argument constructor.
     * 
     * @param errorType the error type
     * @param errorMessage the error message
     */
    public ErrorCode(final ErrorCodeType errorType, final String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the errorType
     */
    public ErrorCodeType getErrorType() {
        return errorType;
    }
    
    /**
     * @param errorType the errorType to set
     */
    public void setErrorType(ErrorCodeType errorType) {
        this.errorType = errorType;
    }
    
    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
