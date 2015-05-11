package com.gpstracker.server.input.handler.gps.converter;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

/**
 * Converts the external UserGpsLocationRegisterRequest to the internal UserGlobalPosition object.
 */
public class GpsLocationRegistrationConverter implements ExternalInputConverter<UserGpsLocationRegisterRequest, UserGlobalPosition> {

    /**
     * Converts the external UserGpsLocationRegisterRequest to the internal UserGlobalPosition object.
     * 
     * @param externalInput the external UserGpsLocationRegisterRequest input
     * @return the internal UserGlobalPosition object
     */
    @Override
    public UserGlobalPosition convert(final UserGpsLocationRegisterRequest externalInput) {
        UserGlobalPosition userGlobalPosition = new UserGlobalPosition();
        userGlobalPosition.getGlobalPosition().setLatitude(Double.valueOf(externalInput.getGpsLocation().getLatitude()));
        userGlobalPosition.getGlobalPosition().setLongitude(Double.valueOf(externalInput.getGpsLocation().getLongitude()));
        userGlobalPosition.setUserId(externalInput.getUserIdentifier().getUserId());
        
        return userGlobalPosition;
    }
}
