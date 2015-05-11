package com.gpstracker.server.model.external.gps;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 * Represents an historic GPS location. The GPS location is associated with a date and time.
 */
public class HistoricGpsLocation extends ExternalEntity {
    
    /** Serial version Id. */
    private static final long serialVersionUID = 8630698023060836110L;
    /** The GPS location. */
    private GpsLocation gpsLocation;
    /** The date associated with GPS location. */
    private String date;
    /** The time associated with the GPS location. */
    private String time;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * 
     * 
     * @return the gpsLocation
     */
    public GpsLocation getGpsLocation() {
        return gpsLocation;
    }
    
    /**
     * 
     * 
     * @param gpsLocation the gpsLocation to set
     */
    public void setGpsLocation(final GpsLocation gpsLocation) {
        this.gpsLocation = gpsLocation;
    }
    
    /**
     * 
     * 
     * @return the date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * 
     * 
     * @param date the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }
    
    /**
     * 
     * 
     * @return the time
     */
    public String getTime() {
        return time;
    }
    
    /**
     * 
     * 
     * @param time the time to set
     */
    public void setTime(final String time) {
        this.time = time;
    }    
}
