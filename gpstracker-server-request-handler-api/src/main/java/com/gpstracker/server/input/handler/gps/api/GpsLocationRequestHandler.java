package com.gpstracker.server.input.handler.gps.api;

import com.gpstracker.server.input.handler.api.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationRequest;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;

public interface GpsLocationRequestHandler extends ExternalInputHandler<UserGpsLocationRequest, UserGpsLocationResponse> {

}
