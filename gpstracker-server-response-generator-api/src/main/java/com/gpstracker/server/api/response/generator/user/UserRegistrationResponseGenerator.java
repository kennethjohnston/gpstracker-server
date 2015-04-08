package com.gpstracker.server.api.response.generator.user;

import com.gpstracker.server.api.response.generator.ResponseGenerator;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;
import com.gpstracker.server.model.internal.result.UserRegistrationProcessingResult;

public interface UserRegistrationResponseGenerator extends ResponseGenerator<UserRegistrationProcessingResult, UserRegistrationResponse> {

}
