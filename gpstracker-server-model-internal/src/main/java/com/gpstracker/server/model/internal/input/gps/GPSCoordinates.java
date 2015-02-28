package com.gpstracker.server.model.internal.input.gps;

import com.gpstracker.server.model.internal.InternalEntity;


/**
 * 
 */
public class GPSCoordinates extends InternalEntity {
	private Double longitude;
	private Double latitude;

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


}
