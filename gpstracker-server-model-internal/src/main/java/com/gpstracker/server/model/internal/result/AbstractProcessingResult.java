package com.gpstracker.server.model.internal.result;

import java.util.ArrayList;
import java.util.List;

import com.gpstracker.server.model.internal.InternalEntity;

public class AbstractProcessingResult extends InternalEntity{
    
    /**  */
    private static final long serialVersionUID = 1L;
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
    public void setSucessfullyProcessed(final boolean sucessfullyProcessed) {
        this.sucessfullyProcessed = sucessfullyProcessed;
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
     * @param warningList the warningList to set
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
}
