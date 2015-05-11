package com.gpstracker.server.api.messageprocessor.gps;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.request.HistoricGlobalPositionRequirements;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

public interface UserGpsLocationHistoryProcessor extends InternalMessageProcessor<HistoricGlobalPositionRequirements, UserHistoricGlobalPositionProcessingResult> {

}
