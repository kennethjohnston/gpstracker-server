package com.gpstracker.server.api.input.handler.user;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.internal.request.UserRegistration;

public interface UserRegistrationRequestHandler extends ExternalInputHandler<UserRegistrationRequest, UserRegistration> {

}
