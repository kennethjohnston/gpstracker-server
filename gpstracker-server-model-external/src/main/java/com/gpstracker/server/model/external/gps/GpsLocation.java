package com.gpstracker.server.model.external.gps;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 * Represents a GPS location submitted by an external entity. This object should not be used for internal
 * processing, it should only be used as interface between the client and the application to represent a 
 * GPS location.
 */
public class GpsLocation extends ExternalEntity {
    
    /** Serial version Id. */
    private static final long serialVersionUID = 2939273021174373731L;
    /** The longitude. */
    private String longitude;
    /** The latitude. */
    private String latitude;

    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * Get the longitude.
     * 
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Set the longitude.
     * 
     * @param longitude the longitude to set
     */
    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the latitude.
     * 
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Set the latitude.
     * 
     * @param latitude the latitude to set
     */
    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }
}
