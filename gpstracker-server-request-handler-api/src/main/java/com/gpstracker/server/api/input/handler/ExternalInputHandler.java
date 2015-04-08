package com.gpstracker.server.api.input.handler;

/**
 * Defines an external input handler. An external input handler will accept external input and will
 * then output an external response associated with the input.
 * 
 * It is important to remember that an external request may require a response to either acknowledge
 * receipt, or to provide an response to a information request.
 *
 * @param <T> the type of the external input/request
 * @param <R> the type of the external output/response
 */
public interface ExternalInputHandler<T, R> {
    
    /**
     * 
     * @param message
     * @return
     */
    R handleInputMessage(T message);
}
