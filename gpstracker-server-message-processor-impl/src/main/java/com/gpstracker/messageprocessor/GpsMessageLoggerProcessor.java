package com.gpstracker.messageprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gpstracker.messageprocessor.api.GpsMessageProcessor;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.service.gps.api.GpsService;

public class GpsMessageLoggerProcessor implements GpsMessageProcessor {

    private static final Logger LOGGER = LogManager.getLogger(GpsMessageLoggerProcessor.class);
    private GpsService gpsService;
    
    /**
     * Process the global position data.
     *
     * @param globalPosition the global position
     * @return return true if the message was processed successfully, false otherwise
     */
    public boolean processGpsCoordinates(final GlobalPosition globalPosition) {
        // Log Metrics
        // Validate Message.
        // Store Message.
        gpsService.store(globalPosition);

        // Process input.
        LOGGER.error("\n-------------------------------------------"
        + "\nReceived: " + globalPosition.toString()
        + "\nLongtitude = " + globalPosition.getLongitude()
        + "\nLatitude = " + globalPosition.getLatitude()
        + "\n-------------------------------------------");

        return true;
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * @return the gpsService
     */
    public GpsService getGpsService() {
        return gpsService;
    }

    /**
     * @param gpsService the gpsService to set
     */
    public void setGpsService(final GpsService gpsService) {
        this.gpsService = gpsService;
    }


    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return LOGGER;
    }
}
