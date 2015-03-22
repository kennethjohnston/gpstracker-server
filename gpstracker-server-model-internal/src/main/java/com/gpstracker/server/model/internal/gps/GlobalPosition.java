package com.gpstracker.server.model.internal.gps;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * An internal representation of a global position.
 */
public class GlobalPosition extends InternalEntity {

    private Double longitude;
    private Double latitude;

    /**
     * Get the longitude.
     * 
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Set the longitude.
     * 
     * @param longitude
     *            the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the latitude.
     * 
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Set the latitude.
     * 
     * @param latitude
     *            the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
