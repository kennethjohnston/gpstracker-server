package com.gpstracker.server.webservice;

import javax.jws.WebMethod;

import com.gpstracker.server.api.core.EntryPointFrameworkHandler;
import com.gpstracker.server.model.external.ExternalEntity;

/**
 * Defines an abstract web service that handles user requests and delegates to a framework handler.
 * 
 * @param <T> the type of request to process
 * @param <R> the type of response to return
 */
public abstract class AbstractWebService<T extends ExternalEntity, R extends ExternalEntity> {

    /** The entry point framework handler to the application. */
    private EntryPointFrameworkHandler handler;
        
    /**
     * Web service that handles the GPS location requests.
     * 
     * @param gpsLocationthe external gps location input
     * @return true if the request was successful, false otherwise
     */
    @SuppressWarnings("unchecked")
    public R handleRequest(final T request) {
        return (R) handler.handle(request);
    }
    
    /**
     * Web service that handles the a client calling back for GPS location request response.
     * 
     * @param gpsLocationthe external gps location input
     * @return true if the request was successful, false otherwise
     */
    @SuppressWarnings("unchecked")
    public R handleCallback(final T request) {        
        return (R) handler.handleCallback(request);
    }     

    // ---------------------------------------------------------------------------------------------
    // Getter and Setter methods
    /**
     * Gets the entry point framework handler.
     * 
     * @return the entry point framework handler.
     */
    @WebMethod(exclude = true)
    public EntryPointFrameworkHandler getHandler() {
        return handler;
    }

    /**
     * Sets the entry point framework handler.
     * 
     * @param handler entry point framework handler to set
     */
    @WebMethod(exclude = true)
    public void setHandler(final EntryPointFrameworkHandler handler) {
        this.handler = handler;
    }
}
