package com.gpstracker.server.api.messageprocessor.gps;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.result.UserGlobalPositionProcessingResult;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

/**
 * Defines how an internal representation of a GPS coordinates/message should be processed. The processor should
 * handle the processing through to completion. Delegation to other processor is possible, however, it is recommended
 * that they adhere to the principles and standards that are applied to the rest of the application.
 * 
 * Implementations of this class should be decoupled from the core operations.
 */
public interface GpsLocationRegistrationProcessor extends InternalMessageProcessor<UserGlobalPosition, UserGlobalPositionProcessingResult> {

}
