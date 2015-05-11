package com.gpstracker.server.model.internal;

import java.util.List;

public class ErrorCodeList extends InternalEntity  {
    
    /** The error code list. */
    private List<ErrorCode> errorCodes;

    //---------------------------------------------------------------------------------------------
    // Getters and Setter
    /**
     * Gets the error code list.
     * 
     * @return the errorCodes
     */
    public List<ErrorCode> getErrorCodes() {
        return errorCodes;
    }

    /**
     * Sets the error code list.
     * 
     * @param errorCodes the errorCodes to set
     */
    public void setErrorCodes(List<ErrorCode> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
