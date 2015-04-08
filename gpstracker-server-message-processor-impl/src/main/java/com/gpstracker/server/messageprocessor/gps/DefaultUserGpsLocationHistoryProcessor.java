package com.gpstracker.server.messageprocessor.gps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gpstracker.server.api.messageprocessor.gps.UserGpsLocationHistoryProcessor;
import com.gpstracker.server.api.service.gps.GpsService;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.request.UserHistoricGlobalPositionRequirements;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

/**
 * The default implementation of how GPS location registrations should be processed. The implementation
 * will store the global position to the database, and will carry out any business logic that has been
 * specific by the business processors.
 */
public class DefaultUserGpsLocationHistoryProcessor extends AbstractMessageProcessor<UserHistoricGlobalPositionRequirements, UserHistoricGlobalPositionProcessingResult> implements UserGpsLocationHistoryProcessor {

    /** The logger to use for this class. */
    private static final Logger LOGGER = LogManager.getLogger(DefaultUserGpsLocationHistoryProcessor.class);
    /** The GPS service. */
    private GpsService gpsService;

    @Override
    protected UserHistoricGlobalPositionProcessingResult processInternal(final UserHistoricGlobalPositionRequirements message) {
        
        
        return new UserHistoricGlobalPositionProcessingResult();
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
