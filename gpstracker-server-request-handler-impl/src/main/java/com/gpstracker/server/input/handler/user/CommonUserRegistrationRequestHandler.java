package com.gpstracker.server.input.handler.user;

import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.input.handler.user.api.UserRegistrationRequestHandler;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.external.response.UserRegistrationResponse;
import com.gpstracker.server.model.internal.request.UserRegistration;

public class CommonUserRegistrationRequestHandler
        extends    AbstractInputHandler<UserRegistrationRequest, UserRegistrationResponse, UserRegistration>
        implements UserRegistrationRequestHandler {

    @Override
    protected boolean isValidate(UserRegistrationRequest message) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected UserRegistrationResponse generateInvalidInputResponse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected UserRegistrationResponse processInternalMessage(
            UserRegistration internalMessage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected UserRegistration parseExternalMessage(
            UserRegistrationRequest message) {
        // TODO Auto-generated method stub
        return null;
    }



}
