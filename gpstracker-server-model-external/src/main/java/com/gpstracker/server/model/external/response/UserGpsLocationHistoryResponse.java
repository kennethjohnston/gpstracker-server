package com.gpstracker.server.model.external.response;

import java.util.List;

import com.gpstracker.server.model.external.gps.HistoricGpsLocation;

public class UserGpsLocationHistoryResponse extends RawUserResponse {

    /** Serial version Id. */
    private static final long serialVersionUID = 930031594570939750L;
    /** The list of historic GPS locations for the user. */
    private List<HistoricGpsLocation> historicGpsLocationList;

    /**
     * @return the historicGpsLocationList
     */
    public List<HistoricGpsLocation> getHistoricGpsLocationList() {
        return historicGpsLocationList;
    }

    /**
     * @param historicGpsLocationList the historicGpsLocationList to set
     */
    public void setHistoricGpsLocationList(List<HistoricGpsLocation> historicGpsLocationList) {
        this.historicGpsLocationList = historicGpsLocationList;
    }

}
