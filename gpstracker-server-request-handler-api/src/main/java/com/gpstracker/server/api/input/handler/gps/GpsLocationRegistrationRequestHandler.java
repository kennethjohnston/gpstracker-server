package com.gpstracker.server.api.input.handler.gps;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public interface GpsLocationRegistrationRequestHandler extends ExternalInputHandler<UserGpsLocationRegisterRequest, UserGlobalPosition> {

}
