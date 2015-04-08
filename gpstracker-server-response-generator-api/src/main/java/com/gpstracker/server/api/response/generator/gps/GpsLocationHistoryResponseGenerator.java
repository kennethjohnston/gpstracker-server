package com.gpstracker.server.api.response.generator.gps;

import com.gpstracker.server.api.response.generator.ResponseGenerator;
import com.gpstracker.server.model.external.response.UserGpsLocationHistoryResponse;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

public interface GpsLocationHistoryResponseGenerator extends ResponseGenerator<UserHistoricGlobalPositionProcessingResult, UserGpsLocationHistoryResponse> {

}
