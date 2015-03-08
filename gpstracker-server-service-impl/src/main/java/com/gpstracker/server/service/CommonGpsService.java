package com.gpstracker.server.service;

import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;
import com.gpstracker.server.service.gps.api.GpsService;
import com.gpstracker.server.service.persister.dao.api.GPSCoordinatesDAO;

public class CommonGpsService implements GpsService {
	
	private GPSCoordinatesDAO persister;

	@Override
	public boolean store(GPSCoordinates gpsCoordinates) {
		return persister.store(gpsCoordinates);
	}

	//---------------------------------------------------------------------------------------------
	// Getters and Setters.
	/**
	 * @return the persister
	 */
	public GPSCoordinatesDAO getPersister() {
		return persister;
	}

	/**
	 * @param persister the persister to set
	 */
	public void setPersister(GPSCoordinatesDAO persister) {
		this.persister = persister;
	}
}
