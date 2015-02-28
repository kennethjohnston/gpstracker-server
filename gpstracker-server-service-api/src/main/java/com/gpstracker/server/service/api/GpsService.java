package com.gpstracker.server.service.api;

import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;

public interface GpsService {
	
	boolean store(GPSCoordinates gpsCoordinates);

}
