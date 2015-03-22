package com.gpstracker.server.core;

import com.gpstracker.messageprocessor.api.InternalMessageProcessor;

/**
 * Initialises the core of the application. 
 */
public class CoreIntialiser {

    public void initialise() {
        InternalMessageProcessor.class.getClassLoader();
    }
}
