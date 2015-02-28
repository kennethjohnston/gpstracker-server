package com.gpstracker.server.model.external.input.gps;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 *
 */
public class GPSLocation extends ExternalEntity {
	private String longitude;
	private String latitude;

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


}
