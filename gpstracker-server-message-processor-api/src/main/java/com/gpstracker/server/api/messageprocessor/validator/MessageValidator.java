package com.gpstracker.server.api.messageprocessor.validator;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * Defines a message validator for an internal message.
 *
 * @param <T> the type of message to validate
 */
public interface MessageValidator<T extends InternalEntity> {

    public boolean validateMessage(T message);
}