package com.gpstracker.server.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gpstracker.server.input.handler.gps.api.GpsLocationRequestHandler;
import com.gpstracker.server.model.external.request.UserGpsLocationRequest;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;

/**
 * GPS Location Webservice.
 */
@WebService 
public class GpsLocationService {
    
    private GpsLocationRequestHandler requestHandler;

    /**
     * Web service that handles the GPS location requests.
     * 
     * @param gpsLocation the external gps location input
     * @return true if the request was successful, false otherwise
     */
    @WebMethod
    public UserGpsLocationResponse gpsLocationRQ(final @WebParam(name="userLocation") UserGpsLocationRequest userGpsLocation) {
        return requestHandler.handleInputMessage(userGpsLocation);
    }
    
    /**
     * Web service that handles the GPS location requests.
     * 
     * @param gpsLocation the external gps location input
     * @return true if the request was successful, false otherwise
     */
    @WebMethod
    public UserGpsLocationResponse gpsLocationCallbackRQ(final @WebParam(name="userLocation") UserGpsLocationRequest userGpsLocation) {
        return requestHandler.handleInputMessage(userGpsLocation);
    }

    //---------------------------------------------------------------------------------------------
    // Getter and Setter methods
    /**
     * @return the requestHandler
     */
    @WebMethod(exclude=true)
    public GpsLocationRequestHandler getRequestHandler() {
        return requestHandler;
    }

    /**
     * @param requestHandler the requestHandler to set
     */
    @WebMethod(exclude=true)
    public void setRequestHandler(GpsLocationRequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
    
}
