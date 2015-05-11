package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.external.response.CallbackResponse;
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
     * @return the user registration response, may contain a callback response.
     */
    public UserRegistrationResponse registerUser(final UserRegistrationRequest userRegistrationRequest) {
        ExternalEntity reponse = super.handleRequest(userRegistrationRequest);
        if (reponse instanceof CallbackResponse) {            
            UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
            userRegistrationResponse.setCallBackResponse((CallbackResponse) reponse);
            userRegistrationResponse.setSuccessful(true);
            reponse = userRegistrationResponse;
        }
        
        return (UserRegistrationResponse) reponse;
    }
    
    /**
     * Web service that handles the callback request for the user registration response.
     * 
     * @param userRegistrationRequest the user registration request
     * @return the user registration response
     */
    public UserRegistrationResponse registerUserResultCallback(final UserRegistrationRequest userRegistrationRequest) {
        return (UserRegistrationResponse) super.handleCallback(userRegistrationRequest);
    } 
}
