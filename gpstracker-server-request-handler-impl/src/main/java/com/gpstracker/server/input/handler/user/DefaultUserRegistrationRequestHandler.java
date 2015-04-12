package com.gpstracker.server.input.handler.user;

import com.gpstracker.server.api.input.handler.user.UserRegistrationRequestHandler;
import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.internal.request.UserRegistration;

public class DefaultUserRegistrationRequestHandler
        extends AbstractInputHandler<UserRegistrationRequest, UserRegistration>
        implements UserRegistrationRequestHandler {

}
