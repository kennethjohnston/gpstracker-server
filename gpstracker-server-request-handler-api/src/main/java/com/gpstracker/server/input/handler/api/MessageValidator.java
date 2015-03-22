package com.gpstracker.server.input.handler.api;

/**
 * 
 *
 * @param <T> the type of message to validate
 */
public interface MessageValidator<T> {

    public boolean validateMessage(T message);
}