package com.gpstracker.server.model.external.request;

import com.gpstracker.server.model.external.gps.GpsLocation;

public class UserGpsLocationRegisterRequest extends AbstractUserRequest {

    /** Serial version Id. */
    private static final long serialVersionUID = -4099308987728951838L;
    /** The GPS location. */
    private GpsLocation gpsLocation;
    
    /**
     * Default Constructor.
     */
    public UserGpsLocationRegisterRequest() {
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters   
    /**
     * Get the GPS location.
     * 
     * @return the gpsLocation
     */
    public GpsLocation getGpsLocation() {
        return gpsLocation;
    }
    
    /**
     * Set the GPS location.
     * 
     * @param gpsLocation the gpsLocation to set
     */
    public void setGpsLocation(GpsLocation gpsLocation) {
        this.gpsLocation = gpsLocation;
    }
}
