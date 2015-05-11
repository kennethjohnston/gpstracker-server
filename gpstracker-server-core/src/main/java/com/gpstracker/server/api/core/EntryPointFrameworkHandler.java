package com.gpstracker.server.api.core;

/**
 * Defines an entry point framework handler of the application. The concept of the application is that the core will control
 * the flow of the application. As part of the core, framework handlers will intrusively control the flow of the application.
 * The entry point framework handler will sit on top of the internal framework handler and provide an entry point for accessing 
 * the internal framework processing.
 */
public interface EntryPointFrameworkHandler extends CoreOperation {

    Object handle(Object argument);
    
    Object handleCallback(Object argument);
}
