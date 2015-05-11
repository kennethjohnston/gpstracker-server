package com.gpstracker.server.input.handler.user.converter;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.model.external.request.UserLoginRequest;
import com.gpstracker.server.model.internal.request.UserLogin;

/**
 * Converts the external UserGpsLocationRegisterRequest to the internal UserGlobalPosition object.
 */
public class UserLoginRequestConverter implements ExternalInputConverter<UserLoginRequest, UserLogin> {

    /**
     * Converts the external UserGpsLocationRegisterRequest to the internal UserGlobalPosition object.
     * 
     * @param externalInput the external UserGpsLocationRegisterRequest input
     * @return the internal UserGlobalPosition objec
     */
    @Override
    public UserLogin convert(final UserLoginRequest externalInput) {
        UserLogin userLogin = new UserLogin();
        userLogin.setPassword(externalInput.getPassword());        
        userLogin.setUserName(externalInput.getUserName());
        
        return userLogin;
    }
}
