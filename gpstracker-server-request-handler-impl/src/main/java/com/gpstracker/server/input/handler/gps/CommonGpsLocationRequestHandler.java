package com.gpstracker.server.input.handler.gps;

import com.gpstracker.server.input.handler.AbstractInputHandler;
import com.gpstracker.server.input.handler.gps.api.GpsLocationRequestHandler;
import com.gpstracker.server.model.external.request.GpsLocationRequest;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;
import com.gpstracker.server.model.internal.gps.GlobalPosition;

public class CommonGpsLocationRequestHandler
        extends AbstractInputHandler<GpsLocationRequest, UserGpsLocationResponse, GlobalPosition>
        implements GpsLocationRequestHandler {

    @Override
    protected boolean isValidate(final GpsLocationRequest message) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected UserGpsLocationResponse generateInvalidInputResponse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected UserGpsLocationResponse processInternalMessage(final GlobalPosition internalMessage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected GlobalPosition parseExternalMessage(final GpsLocationRequest message) {
        // TODO Auto-generated method stub
        return null;
    }

}
