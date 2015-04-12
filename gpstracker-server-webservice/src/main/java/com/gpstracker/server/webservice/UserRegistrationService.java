package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.external.response.RawUserResponse;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;

/**
 * The web service that handles a user registration request.
 */
@WebService
public class UserRegistrationService extends AbstractWebService<UserRegistrationRequest, UserRegistrationResponse> {

    /**
     * Registers a user account for the gps tracking service.
     *  
     * @param userRegistrationRequest the user registration request
     * @return the user registration response
     */
    public UserRegistrationResponse registerUser(final UserRegistrationRequest userRegistrationRequest) {
        Object reponse = super.handleRequest(userRegistrationRequest);
        if (reponse instanceof RawUserResponse) {
            UserRegistrationResponse userGpsLocationResponse = new UserRegistrationResponse();
            userGpsLocationResponse.setCallBackResponse(((RawUserResponse) reponse).getCallBackResponse());            
            reponse = userGpsLocationResponse;
        }        
        return (UserRegistrationResponse) reponse;
    }
}
