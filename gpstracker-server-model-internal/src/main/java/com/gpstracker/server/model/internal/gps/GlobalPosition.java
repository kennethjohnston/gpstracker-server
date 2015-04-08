package com.gpstracker.server.model.internal.gps;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * An internal representation of a global position.
 */
public class GlobalPosition extends InternalEntity {

    /** . */
    private Double longitude;
    /** . */
    private Double latitude;
    /** The date associated with the location. */
    private DateTime dateTime;

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

    /**
     * @return the dateTime
     */
    public DateTime getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
