package com.gpstracker.messageprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gpstracker.messageprocessor.api.GpsMessageProcessor;
import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;
import com.gpstracker.server.service.gps.api.GpsService;

public class GpsMessageLoggerProcessor implements GpsMessageProcessor {

	private static final Logger LOGGER = LogManager.getLogger(GpsMessageLoggerProcessor.class);
	private GpsService gpsService;
	
	public boolean processGpsCoordinates(GPSCoordinates gpsCoordinates) {
		
		// Log Metrics
		
		// Validate Message.
		
		// Store Message.
		gpsService.store(gpsCoordinates);
		
		// Process input.
		LOGGER.error("\n-------------------------------------------"
		+ "\nReceived: " + gpsCoordinates.toString()
		+ "\nLongtitude = " + gpsCoordinates.getLongitude()
		+ "\nLatitude = " + gpsCoordinates.getLatitude()
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
	public void setGpsService(GpsService gpsService) {
		this.gpsService = gpsService;
	}


	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
	}
}
