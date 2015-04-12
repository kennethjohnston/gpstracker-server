package com.gpstracker.server.model.external.response;

import java.util.List;

import com.gpstracker.server.model.external.gps.HistoricGpsLocation;

public class UserGpsLocationHistoryResponse extends RawUserResponse {

    /** The list of historic GPS locations for the user. */
    private List<HistoricGpsLocation> historicGpsLocationList;

}
