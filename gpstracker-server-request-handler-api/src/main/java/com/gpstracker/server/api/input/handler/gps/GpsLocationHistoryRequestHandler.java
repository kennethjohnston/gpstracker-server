package com.gpstracker.server.api.input.handler.gps;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.internal.request.HistoricGlobalPositionRequirements;

public interface GpsLocationHistoryRequestHandler extends ExternalInputHandler<UserGpsLocationHistoryRequest, HistoricGlobalPositionRequirements> {

}
