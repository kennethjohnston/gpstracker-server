package com.gpstracker.server.response.generator.gps;

import com.gpstracker.server.api.response.generator.gps.GpsLocationResponseGenerator;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;
import com.gpstracker.server.model.internal.result.UserGlobalPositionProcessingResult;

public class DefaultGpsLocationResponseGenerator implements GpsLocationResponseGenerator {

    @Override
    public UserGpsLocationResponse generateResponse(final UserGlobalPositionProcessingResult processingResult) {
        UserGpsLocationResponse response = new UserGpsLocationResponse();
        response.setSuccessful(true);
        
        return response;
    }
}
