package com.gpstracker.server.model.external.response;

import java.util.List;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.gps.HistoricGpsLocation;
import com.gpstracker.server.model.external.user.UserIdentifier;

public class UserGpsLocationHistoryResponse extends AbstractUserResponse {
    
    /** The user identifier. */
    private UserIdentifier userIdentifier;
    /** The list of historic GPS locations for the user. */
    private List<HistoricGpsLocation> historicGpsLocationList;

}
