package com.gpstracker.server.model.internal.result;

import java.util.List;

import com.gpstracker.server.model.internal.InternalEntity;

public class AbstractProcessingResult extends InternalEntity{
    
    /** Indicates if the processing was successful. */
    private boolean sucessfullyProcessed;
    /** List of errors associated with processing. */
    private List<String> errorList;
    /** List of warnings associated with processing. */
    private List<String> warningList;
    
    /**
     * @return the sucessfullyProcessed
     */
    public boolean isSucessfullyProcessed() {
        return sucessfullyProcessed;
    }
    
    /**
     * @param sucessfullyProcessed the sucessfullyProcessed to set
     */
    public void setSucessfullyProcessed(boolean sucessfullyProcessed) {
        this.sucessfullyProcessed = sucessfullyProcessed;
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
}
