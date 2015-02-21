package com.gpstracker.server.core.api.response;

import com.gpstracker.model.external.output.CallbackResponse;

/**
 * Defines a factory class that generates a callback response to send back to the client.
 */
public interface CallbackResponseFactory {

	CallbackResponse getCallbackResponse();

}
