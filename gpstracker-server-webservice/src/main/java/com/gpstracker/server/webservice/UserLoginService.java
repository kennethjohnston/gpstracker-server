package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.request.UserLoginRequest;
import com.gpstracker.server.model.external.response.CallbackResponse;
import com.gpstracker.server.model.external.response.UserLoginResponse;

/**
 * The web service that handles a user login request. The service will determine if the user has a valid account for the service.
 */
@WebService
public class UserLoginService extends AbstractWebService<UserLoginRequest, UserLoginResponse> {

    /**
     * Verifies a user account for the gps tracking service.
     *  
     * @param userloginRequest the user login request
     * @return the user login response, may contain a callback response.
     */
    public UserLoginResponse loginVerification(final UserLoginRequest userloginRequest) {
        ExternalEntity reponse = super.handleRequest(userloginRequest);
        if (reponse instanceof CallbackResponse) { 
            UserLoginResponse userLoginResponse = new UserLoginResponse();
            userLoginResponse.setCallBackResponse((CallbackResponse) reponse);
            userLoginResponse.setSuccessful(true);
            reponse = userLoginResponse;
        }
        
        return (UserLoginResponse) reponse;
    }
    
    /**
     * Verifies a user account for the gps tracking service.
     *  
     * @param userloginRequest the user login request
     * @return the user login response
     */
    public UserLoginResponse registerLocationResultCallback(final UserLoginRequest userloginRequest) {
        return (UserLoginResponse) super.handleCallback(userloginRequest);
    } 
}
