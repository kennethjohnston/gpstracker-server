package com.gpstracker.server.api.input.handler;

import java.util.List;

import com.gpstracker.server.model.external.ErrorCode;

/**
 * Validates the external input received. Data received from an external entity is not governed by the
 * server the application, therefore strict validation should be performed to ensure that malformed, invalid
 * or damaging data is not processed.
 * 
 * Each implementation of the external input validator should perform a single type of validation. A single 
 * implementation should NOT perform all validation.
 *
 * @param <T> the type of message to validate
 */
public interface ExternalInputValidator<T> {

    /**
     * Validates an input message from an external source.
     * 
     * @param message
     * @return true if the input is considered valid, false otherwise.
     */
    public List<ErrorCode> validateMessage(T message);
}