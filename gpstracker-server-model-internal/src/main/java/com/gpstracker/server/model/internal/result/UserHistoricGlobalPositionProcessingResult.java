package com.gpstracker.server.model.internal.result;

import com.gpstracker.server.model.internal.gps.GlobalPositionList;

public class UserHistoricGlobalPositionProcessingResult extends AbstractProcessingResult {

    private static final long serialVersionUID = 1L;    
    /** The list of historic location. */
    private GlobalPositionList historicGlobalPositionList;

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the historicGlobalPositionList
     */
    public GlobalPositionList getHistoricGlobalPositionList() {
        return historicGlobalPositionList;
    }

    /**
     * @param historicGlobalPositionList the historicGlobalPositionList to set
     */
    public void setHistoricGlobalPositionList(GlobalPositionList historicGlobalPositionList) {
        this.historicGlobalPositionList = historicGlobalPositionList;
    }
}
