package com.gpstracker.server.response.generator.user;

import com.gpstracker.server.api.response.generator.user.UserRegistrationResponseGenerator;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;
import com.gpstracker.server.model.internal.result.UserRegistrationProcessingResult;

public class DefaultUserRegistrationResponseGenerator implements UserRegistrationResponseGenerator {

    @Override
    public UserRegistrationResponse generateResponse(final UserRegistrationProcessingResult processingResult) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        
        return response;
    }
}
