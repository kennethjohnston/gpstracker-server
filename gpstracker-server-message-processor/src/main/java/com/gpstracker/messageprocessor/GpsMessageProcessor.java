package com.gpstracker.messageprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gpstracker.model.internal.GPSCoordinates;

public class GpsMessageProcessor {

	private static final Logger LOGGER = LogManager.getLogger(GpsMessageProcessor.class);

	public boolean processGpsCoordinates(GPSCoordinates gpsCoordinates) {
		
		// Log Metrics
		
		// Validate Message.
		
		// Store Message.
		
		// Process input.
		LOGGER.error("\n-------------------------------------------"
		+ "\nReceived: " + gpsCoordinates.toString()
		+ "\nLongtitude = " + gpsCoordinates.getLongitude()
		+ "\nLatitude = " + gpsCoordinates.getLatitude()
		+ "\n-------------------------------------------");

		return true;
	}

}
