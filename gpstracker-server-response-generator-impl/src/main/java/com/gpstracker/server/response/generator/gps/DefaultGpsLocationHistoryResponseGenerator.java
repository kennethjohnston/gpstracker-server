package com.gpstracker.server.response.generator.gps;

import com.gpstracker.server.api.response.generator.gps.GpsLocationHistoryResponseGenerator;
import com.gpstracker.server.model.external.response.UserGpsLocationHistoryResponse;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

public class DefaultGpsLocationHistoryResponseGenerator implements GpsLocationHistoryResponseGenerator {

    @Override
    public UserGpsLocationHistoryResponse generateResponse(final UserHistoricGlobalPositionProcessingResult processingResult ) {
        UserGpsLocationHistoryResponse response = new UserGpsLocationHistoryResponse();
        response.setSuccessful(true);
        
        return response;
    }
}
