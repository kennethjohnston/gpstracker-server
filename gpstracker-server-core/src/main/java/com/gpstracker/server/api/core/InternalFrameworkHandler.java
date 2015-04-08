package com.gpstracker.server.api.core;

import com.gpstracker.server.model.internal.ProcessingContext;

/**
 * Defines an architecture handler of the application. The concept of the application is that the core will control
 * the flow of the application. The core handlers are intrusive and help control the flow of the application.
 */
public interface InternalFrameworkHandler {

    public Object handle(ProcessingContext processingContext, Object argument);
}
