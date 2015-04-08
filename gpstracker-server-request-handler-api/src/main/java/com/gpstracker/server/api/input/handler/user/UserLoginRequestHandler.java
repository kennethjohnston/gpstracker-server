package com.gpstracker.server.api.input.handler.user;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserLoginRequest;
import com.gpstracker.server.model.internal.request.UserLogin;

public interface UserLoginRequestHandler extends ExternalInputHandler<UserLoginRequest, UserLogin> {

}
