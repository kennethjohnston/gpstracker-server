package com.gpstracker.server.input.handler.gps;

import com.gpstracker.server.api.input.handler.gps.GpsLocationHistoryRequestHandler;
import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.internal.request.UserHistoricGlobalPositionRequirements;

public class DefaultGpsLocationHistoryRequestHandler
        extends AbstractInputHandler<UserGpsLocationHistoryRequest, UserHistoricGlobalPositionRequirements>
        implements GpsLocationHistoryRequestHandler {

    @Override
    protected boolean isValidate(UserGpsLocationHistoryRequest message) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected UserHistoricGlobalPositionRequirements convertToInternal(
            UserGpsLocationHistoryRequest message) {
        // TODO Auto-generated method stub
        return null;
    }

}
