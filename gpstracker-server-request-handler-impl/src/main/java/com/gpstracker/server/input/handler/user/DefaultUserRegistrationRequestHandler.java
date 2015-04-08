package com.gpstracker.server.input.handler.user;

import com.gpstracker.server.api.input.handler.user.UserRegistrationRequestHandler;
import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;
import com.gpstracker.server.model.internal.request.UserRegistration;

public class DefaultUserRegistrationRequestHandler
        extends AbstractInputHandler<UserRegistrationRequest, UserRegistration>
        implements UserRegistrationRequestHandler {

    @Override
    protected boolean isValidate(UserRegistrationRequest message) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected UserRegistration convertToInternal(UserRegistrationRequest message) {
        // TODO Auto-generated method stub
        return null;
    }

}
