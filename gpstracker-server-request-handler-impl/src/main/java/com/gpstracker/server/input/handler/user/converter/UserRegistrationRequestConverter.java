package com.gpstracker.server.input.handler.user.converter;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;
import com.gpstracker.server.model.internal.request.UserRegistration;

/**
 * Converts the external UserGpsLocationRegisterRequest to the internal UserGlobalPosition object.
 */
public class UserRegistrationRequestConverter implements ExternalInputConverter<UserRegistrationRequest, UserRegistration> {

    /**
     * Converts the external UserGpsLocationRegisterRequest to the internal UserGlobalPosition object.
     * 
     * @param externalInput the external UserGpsLocationRegisterRequest input
     * @return the internal UserGlobalPosition objec
     */
    @Override
    public UserRegistration convert(final UserRegistrationRequest externalInput) {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setUserName(externalInput.getUserName());
        userRegistration.setPassword(externalInput.getPassword());
        userRegistration.setPhoneNumber(externalInput.getPhoneNumber());
        userRegistration.setEmailAddress(externalInput.getEmailAddress());
        
        return userRegistration;
    }
}
