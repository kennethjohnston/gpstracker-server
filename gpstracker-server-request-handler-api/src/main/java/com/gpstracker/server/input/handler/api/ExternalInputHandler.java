package com.gpstracker.server.input.handler.api;

/**
 * 
 *
 * @param <T>
 * @param <R>
 */
public interface ExternalInputHandler<T, R> {
    
    /**
     * 
     * @param message
     * @return
     */
    R handleInputMessage(T message);
}
