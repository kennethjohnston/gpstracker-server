package com.gpstracker.server.api.response.generator.user;

import com.gpstracker.server.api.response.generator.ResponseGenerator;
import com.gpstracker.server.model.external.response.UserLoginResponse;
import com.gpstracker.server.model.internal.result.UserLoginProcessingResult;

public interface UserLoginResponseGenerator extends ResponseGenerator<UserLoginProcessingResult, UserLoginResponse> {

}
