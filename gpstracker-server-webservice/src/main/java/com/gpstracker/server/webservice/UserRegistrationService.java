package com.gpstracker.server.webservice;

import javax.jws.WebService;

import com.gpstracker.server.input.handler.user.api.UserRegistrationRequestHandler;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;

/**
 * User registration servicer
 */
@WebService
public class UserRegistrationService {
    
    private UserRegistrationRequestHandler requestHandler;    
    
    public UserRegistrationResponse registerUser(final UserRegistrationRequest userRegistrationRequest) {
        return requestHandler.handleInputMessage(userRegistrationRequest);
    }
}
