package com.gpstracker.server.input.conveter;

import com.gpstracker.server.input.conveter.api.ExternalInputConverter;
import com.gpstracker.server.model.external.input.gps.GPSLocation;
import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;

public class GpsLocationExternalInputConverter implements ExternalInputConverter<GPSLocation, GPSCoordinates> {

	/**
	 * The the external input into the internal model object.
	 * 
	 * @param externalInput the external input
	 * @return the gps coordinates
	 */
	@Override
	public GPSCoordinates convert(GPSLocation externalInput) {
		GPSCoordinates gpsCoordinates = new GPSCoordinates();
		gpsCoordinates.setLatitude(Double.valueOf(externalInput.getLatitude()));
		gpsCoordinates.setLongitude(Double.valueOf(externalInput.getLongitude()));
		
		return gpsCoordinates;
	}
}
