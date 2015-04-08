package com.gpstracker.server.model.external.response;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 * @author kenneth
 *
 */
public class AbstractUserResponse  extends ExternalEntity {
    
    /** Indicates if the transaction was successful. */
    private boolean successful;
    /** The callback response. */
    private CallbackResponse callBackResponse;
    
    /**
     * @return the successful
     */
    public boolean isSuccessful() {
        return successful;
    }
    
    /**
     * @param successful the successful to set
     */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
    
    /**
     * @return the callBackResponse
     */
    public CallbackResponse getCallBackResponse() {
        return callBackResponse;
    }
    
    /**
     * @param callBackResponse the callBackResponse to set
     */
    public void setCallBackResponse(CallbackResponse callBackResponse) {
        this.callBackResponse = callBackResponse;
    }
    
}
