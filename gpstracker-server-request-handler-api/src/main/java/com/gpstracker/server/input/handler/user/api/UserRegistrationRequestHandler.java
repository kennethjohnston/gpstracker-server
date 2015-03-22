package com.gpstracker.server.input.handler.user.api;

import com.gpstracker.server.input.handler.api.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;

public interface UserRegistrationRequestHandler extends ExternalInputHandler<UserRegistrationRequest, UserRegistrationResponse> {

}
