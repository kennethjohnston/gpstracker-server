package com.gpstracker.server.api.response.generator.gps;

import com.gpstracker.server.api.response.generator.ResponseGenerator;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;
import com.gpstracker.server.model.internal.result.UserGlobalPositionProcessingResult;

public interface GpsLocationResponseGenerator extends ResponseGenerator<UserGlobalPositionProcessingResult, UserGpsLocationResponse> {

}
