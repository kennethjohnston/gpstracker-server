package com.gpstracker.server.api.core;

import com.gpstracker.server.model.internal.ProcessingContext;

/**
 * Defines an architecture handler of the application. The concept of the framework handler is that
 * the core will use them to determine when and how business should be called. Also, they should provide
 * a mechanism to control the flow of the application.
 */
public interface InternalFrameworkHandler extends CoreOperation {

    /**
     * Handles the invocation of the framework handler.
     * 
     * @param processingContext the processing context
     * @param argument the input argument
     * @return the response from processing the underlying business logic
     */
    Object handle(ProcessingContext processingContext, Object argument);    
}
