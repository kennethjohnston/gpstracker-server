package com.gpstracker.server.api.core.response;

import com.gpstracker.server.model.external.response.CallbackResponse;

/**
 * Defines a factory class that generates a callback response to send back to the client.
 */
public interface CallbackResponseFactory {

    CallbackResponse getCallbackResponse();

}
