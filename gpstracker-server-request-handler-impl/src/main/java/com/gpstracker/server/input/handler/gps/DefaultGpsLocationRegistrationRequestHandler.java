package com.gpstracker.server.input.handler.gps;

import com.gpstracker.server.api.input.handler.gps.GpsLocationRegistrationRequestHandler;
import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public class DefaultGpsLocationRegistrationRequestHandler
        extends AbstractInputHandler<UserGpsLocationRegisterRequest, UserGlobalPosition>
        implements GpsLocationRegistrationRequestHandler {

}
