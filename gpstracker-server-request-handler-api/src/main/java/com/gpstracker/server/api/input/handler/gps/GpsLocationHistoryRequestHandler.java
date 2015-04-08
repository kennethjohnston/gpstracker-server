package com.gpstracker.server.api.input.handler.gps;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.internal.request.UserHistoricGlobalPositionRequirements;

public interface GpsLocationHistoryRequestHandler extends ExternalInputHandler<UserGpsLocationHistoryRequest, UserHistoricGlobalPositionRequirements> {

}
