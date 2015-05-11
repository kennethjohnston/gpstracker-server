package com.gpstracker.server.response.generator.user;

import com.gpstracker.server.api.response.generator.user.UserLoginResponseGenerator;
import com.gpstracker.server.model.external.response.UserLoginResponse;
import com.gpstracker.server.model.external.user.UserIdentifier;
import com.gpstracker.server.model.internal.result.UserLoginProcessingResult;

public class DefaultUserLoginResponseGenerator implements UserLoginResponseGenerator {

    @Override
    public UserLoginResponse generateResponse(final UserLoginProcessingResult processingResult) {
        UserLoginResponse response = new UserLoginResponse();        
        if (processingResult.getUser() != null) {
            UserIdentifier userIdentifier = new UserIdentifier();
            userIdentifier.setUserId(processingResult.getUser().getUserId());
            response.setUserIdentifier(userIdentifier);
            response.setSuccessful(true);
        } else {
            response.addError("Invalid details provided");
            response.setSuccessful(false);
        }
        
        return response;
    }
}
