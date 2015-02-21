package com.gpstracker.server.core.api.input.processor;

/**
 * Defines a external input processing operation of the application, all other external input processing operations
 * should be a derivative of this operation.
 *
 * External input processing operation can be considered any operation that accepts input from an external entity outside of  the
 * application, this will generally be clients. The external input processing should rely upon the external model as input, and transform
 * the external input to the application internal model.
 */
public interface XExternalInputProcessingOperation {

}
