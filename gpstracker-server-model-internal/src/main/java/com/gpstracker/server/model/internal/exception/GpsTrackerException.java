package com.gpstracker.server.model.internal.exception;

/**
 * High level exception for the application. All checked application exception should extend from this
 * exception. This allows the application specific exceptions to be caught under the one exception if
 * required.
 * 
 * Application specific exceptions should be used for specific and exceptional circumstances in the application. 
 * The java language language exceptions should be used where applicable. The application specific exceptions
 * should only be required where the exception is not related to the java language, but is unique to the application.
 */
public class GpsTrackerException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -5150202848760971161L;

}
