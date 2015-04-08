package com.gpstracker.server.api.messageprocessor.gps;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.request.UserHistoricGlobalPositionRequirements;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

public interface UserGpsLocationHistoryProcessor extends InternalMessageProcessor<UserHistoricGlobalPositionRequirements, UserHistoricGlobalPositionProcessingResult> {

}
