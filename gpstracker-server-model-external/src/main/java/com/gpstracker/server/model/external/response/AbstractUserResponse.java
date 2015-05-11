package com.gpstracker.server.model.external.response;

import java.util.ArrayList;
import java.util.List;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 *
 */
public class AbstractUserResponse  extends ExternalEntity {
    
    /** Serial version Id. */
    private static final long serialVersionUID = 940258390733003740L;
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
     * @return the errorList, never null
     */
    public List<String> getErrorList() {
        if (errorList == null) {
            errorList = new ArrayList<String>();
        }
        
        return errorList;
    }
    
    /**
     * @param errorList the errorList to set
     */
    public void setErrorList(final List<String> errorList) {
        this.errorList = errorList;
    }

    /**
     * 
     * @param error
     * @return
     */
    public boolean addError(final String error) {
        return getErrorList().add(error);
    }

    /**
     * @return the warningList
     */
    public List<String> getWarningList() {
        if (warningList == null) {
            warningList = new ArrayList<String>();
        }

        return warningList;
    }

    /**
     * @param warningList
     *            the warningList to set
     */
    public void setWarningList(final List<String> warningList) {
        this.warningList = warningList;
    }

    /**
     * 
     * @param warning
     * @return
     */
    public boolean addWarning(final String warning) {
        return getWarningList().add(warning);
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
