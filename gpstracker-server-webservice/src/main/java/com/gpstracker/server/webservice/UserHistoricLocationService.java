package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.external.response.UserGpsLocationHistoryResponse;

/**
 * The web service that handles a user login request. The service will determine if the user has a valid account for the service.
 */
@WebService
public class UserHistoricLocationService extends AbstractWebService<UserGpsLocationHistoryRequest, UserGpsLocationHistoryResponse> {
   
    /**
     * Retrieves a users GPS location history.
     *  
     * @param gpsLocationHistoryRequest the GPS location history request
     * @return the user registration response
     */
    public UserGpsLocationHistoryResponse retrieveGPSLocationHistory(final UserGpsLocationHistoryRequest gpsLocationHistoryRequest) {
        return (UserGpsLocationHistoryResponse) super.handleRequest(gpsLocationHistoryRequest);
    }  
}
