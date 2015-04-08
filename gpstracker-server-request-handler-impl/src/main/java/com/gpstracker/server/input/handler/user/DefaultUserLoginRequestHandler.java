package com.gpstracker.server.input.handler.user;

import com.gpstracker.server.api.input.handler.user.UserLoginRequestHandler;
import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.model.external.request.UserLoginRequest;
import com.gpstracker.server.model.external.response.UserLoginResponse;
import com.gpstracker.server.model.internal.request.UserLogin;

public class DefaultUserLoginRequestHandler
        extends AbstractInputHandler<UserLoginRequest, UserLogin>
        implements UserLoginRequestHandler {

    @Override
    protected boolean isValidate(UserLoginRequest message) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected UserLogin convertToInternal(UserLoginRequest message) {
        // TODO Auto-generated method stub
        return null;
    }

 
}
