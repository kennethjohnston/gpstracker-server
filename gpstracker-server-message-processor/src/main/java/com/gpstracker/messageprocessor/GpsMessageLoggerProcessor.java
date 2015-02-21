package com.gpstracker.messageprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gpstracker.messageprocessor.api.GpsMessageProcessor;
import com.gpstracker.model.internal.input.gps.GPSCoordinates;

public class GpsMessageLoggerProcessor implements GpsMessageProcessor {

	private static final Logger LOGGER = LogManager.getLogger(GpsMessageLoggerProcessor.class);

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
