package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.external.response.CallbackResponse;
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
     * @return the user registration response, may contain a callback response.
     */
    public UserGpsLocationHistoryResponse retrieveGPSLocationHistory(final UserGpsLocationHistoryRequest gpsLocationHistoryRequest) {
        ExternalEntity reponse = super.handleRequest(gpsLocationHistoryRequest);
        if (reponse instanceof CallbackResponse) {            
            UserGpsLocationHistoryResponse userGpsLocationHistoryResponse = new UserGpsLocationHistoryResponse();
            userGpsLocationHistoryResponse.setCallBackResponse((CallbackResponse) reponse);
            userGpsLocationHistoryResponse.setSuccessful(true);
            reponse = userGpsLocationHistoryResponse;
        }
        
        return (UserGpsLocationHistoryResponse) reponse;
    }
    
    /**
     * Retrieves a users GPS location history.
     *  
     * @param gpsLocationHistoryRequest the GPS location history request
     * @return the user registration response
     */
    public UserGpsLocationHistoryResponse registerLocationResultCallback(final UserGpsLocationHistoryRequest gpsLocationHistoryRequest) {
        return (UserGpsLocationHistoryResponse) super.handleCallback(gpsLocationHistoryRequest);
    } 
}
