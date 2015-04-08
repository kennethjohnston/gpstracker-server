package com.gpstracker.server.api.messageprocessor.validator;

/**
 * 
 *
 * @param <T> the type of message to validate
 */
public interface MessageValidator<T> {

    public boolean validateMessage(T message);
}