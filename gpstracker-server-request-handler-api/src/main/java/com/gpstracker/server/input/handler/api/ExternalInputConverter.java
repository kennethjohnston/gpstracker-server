package com.gpstracker.server.input.handler.api;

/**
 * Convert an external input object to a common internal format that can be processed by the 
 * application. 
 * 
 * This conversion is required to support decoupling from the external object. The internal object
 * may be allowed to change which should not affect or drive changes to the external entities that 
 * submit changes to the application.
 * 
 * @param <T> the type of the external input object
 * @param <R> the type of the equivalent internal object
 */
public interface ExternalInputConverter<T, R> {

    /**
     * Convert the internal input to the related internal object.
     * @param externalInput
     * @return
     */
    R convert(T externalInput);
}
