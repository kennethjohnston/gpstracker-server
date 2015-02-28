package com.gpstracker.messageprocessor.validator.api;

/**
 * 
 *
 * @param <T> the type of message to validate
 */
public interface MessageValidator<T> {

	public boolean validateMessage(T message);
}