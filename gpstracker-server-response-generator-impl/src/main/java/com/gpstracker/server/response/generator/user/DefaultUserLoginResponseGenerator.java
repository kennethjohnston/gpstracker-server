package com.gpstracker.server.response.generator.user;

import com.gpstracker.server.api.response.generator.user.UserLoginResponseGenerator;
import com.gpstracker.server.model.external.response.UserLoginResponse;
import com.gpstracker.server.model.internal.result.UserLoginProcessingResult;

public class DefaultUserLoginResponseGenerator implements UserLoginResponseGenerator {

    @Override
    public UserLoginResponse generateResponse(final UserLoginProcessingResult processingResult) {
        UserLoginResponse response = new UserLoginResponse();
        
        return response;
    }
}
