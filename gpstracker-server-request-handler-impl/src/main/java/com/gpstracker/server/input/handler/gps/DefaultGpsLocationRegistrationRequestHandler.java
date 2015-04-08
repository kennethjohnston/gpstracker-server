package com.gpstracker.server.input.handler.gps;

import com.gpstracker.server.api.input.handler.gps.GpsLocationRegistrationRequestHandler;
import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public class DefaultGpsLocationRegistrationRequestHandler
        extends AbstractInputHandler<UserGpsLocationRegisterRequest, UserGlobalPosition>
        implements GpsLocationRegistrationRequestHandler {

    @Override
    protected boolean isValidate(final UserGpsLocationRegisterRequest message) {
        if (message == null) {
            return false;
        }
        
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected UserGlobalPosition convertToInternal(final UserGpsLocationRegisterRequest message) {
        UserGlobalPosition userGlobalPosition = new UserGlobalPosition();
        userGlobalPosition.getGlobalPosition().setLatitude(Double.valueOf(message.getGpsLocation().getLatitude()));
        userGlobalPosition.getGlobalPosition().setLongitude(Double.valueOf(message.getGpsLocation().getLongitude()));
        userGlobalPosition.setUserId(Long.valueOf(message. getUserIdentifier().getUserId()));
        
        return userGlobalPosition;
    }

}
