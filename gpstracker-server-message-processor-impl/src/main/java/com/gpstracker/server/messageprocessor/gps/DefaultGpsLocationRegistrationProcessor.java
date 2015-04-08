package com.gpstracker.server.messageprocessor.gps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gpstracker.server.api.messageprocessor.gps.GpsLocationRegistrationProcessor;
import com.gpstracker.server.api.service.gps.GpsService;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.result.UserGlobalPositionProcessingResult;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

/**
 * The default implementation of how GPS location registrations should be processed. The implementation
 * will store the global position to the database, and will carry out any business logic that has been
 * specific by the business processors.
 */
public class DefaultGpsLocationRegistrationProcessor extends AbstractMessageProcessor<UserGlobalPosition, UserGlobalPositionProcessingResult> implements GpsLocationRegistrationProcessor {

    /** The logger to use for this class. */
    private static final Logger LOGGER = LogManager.getLogger(DefaultGpsLocationRegistrationProcessor.class);
    /** The GPS service. */
    private GpsService gpsService;
   
    /**
     * Process the user's global position data.
     *
     * @param userGlobalPosition the user's global position
     * @return the external response to send back to user
     */
    @Override
    public UserGlobalPositionProcessingResult processInternal(final UserGlobalPosition userGlobalPosition) {
        // Log Metrics
        // Validate Message.
        // Store Message.
        gpsService.store(userGlobalPosition);
        // Process input.

        return new UserGlobalPositionProcessingResult();
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * Gets the GPS service.
     *
     * @return the gpsService
     */
    public GpsService getGpsService() {
        return gpsService;
    }

    /**
     * Sets the GPS service.
     *
     * @param gpsService the gpsService to set
     */
    public void setGpsService(final GpsService gpsService) {
        this.gpsService = gpsService;
    }
}
