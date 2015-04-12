package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.model.external.request.UserLoginRequest;
import com.gpstracker.server.model.external.response.RawUserResponse;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;
import com.gpstracker.server.model.external.response.UserLoginResponse;

/**
 * The web service that handles a user login request. The service will determine if the user has a valid account for the service.
 */
@WebService
public class UserLoginService extends AbstractWebService<UserLoginRequest, UserLoginResponse> {

    /**
     * Registers a user account for the gps tracking service.
     *  
     * @param userloginRequest the user login request
     * @return the user registration response
     */
    public UserLoginResponse loginVerification(final UserLoginRequest userloginRequest) {
        Object reponse = super.handleRequest(userloginRequest);
        if (reponse instanceof RawUserResponse) {
            UserLoginResponse userGpsLocationResponse = new UserLoginResponse();
            userGpsLocationResponse.setCallBackResponse(((RawUserResponse) reponse).getCallBackResponse());            
            reponse = userGpsLocationResponse;
        }
        
        return (UserLoginResponse) reponse;
    }
}
