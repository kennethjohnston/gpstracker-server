package com.gpstracker.server.model.external.response;

import java.util.List;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 * @author kenneth
 *
 */
public class AbstractUserResponse  extends ExternalEntity {
    
    /** Indicates if the transaction was successful. */
    private boolean successful;
    /** List of errors associated with processing. */
    private List<String> errorList;
    /** List of warnings associated with processing. */
    private List<String> warningList;
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
     * @return the errorList
     */
    public List<String> getErrorList() {
        return errorList;
    }
    
    /**
     * @param errorList the errorList to set
     */
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    
    /**
     * @return the warningList
     */
    public List<String> getWarningList() {
        return warningList;
    }
    
    /**
     * @param warningList the warningList to set
     */
    public void setWarningList(List<String> warningList) {
        this.warningList = warningList;
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
