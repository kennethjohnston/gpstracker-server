package com.gpstracker.server.model.internal.mq;

/**
 * Defines the internal message types that the will passed between the layers of the application.
 */
public enum InternalMessageType {
    
    EXTERNAL_MESSAGE_INPUT,
    INTERNAL_MESSAGE_PROCESSING,
    INTERNAL_RESPONSE_PROCESSING
}
