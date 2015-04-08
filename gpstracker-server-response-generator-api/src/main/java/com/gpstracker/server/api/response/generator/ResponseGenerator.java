package com.gpstracker.server.api.response.generator;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;

/**
 * Defines a generic response generator the generator should create a response that can be sent back to a client.
 *
 * @param <T> the type of the internal input
 * @param <R> the type of the external output
 */
public interface ResponseGenerator<T extends InternalEntity, R extends ExternalEntity>  {

    R generateResponse(T processingResult);
}
