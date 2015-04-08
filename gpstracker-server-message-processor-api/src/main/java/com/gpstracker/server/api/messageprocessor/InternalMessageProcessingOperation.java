package com.gpstracker.server.api.messageprocessor;

/**
 * Defines an internal message processing operation of the application, all other internal message processing operations
 * should be a derivative of this operation.
 *
 * Internal message processing operation can be considered any operation that accepts an internal message that requires processing,
 * this will generally be from input from the external input layer. The message processing operations should also persist processing
 * results (if required).
 */
public interface InternalMessageProcessingOperation {

}
