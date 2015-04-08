package com.gpstracker.server.response.generator;

/**
 * Defines a generic response generator the generator should create a response that can be sent back to a client.
 *
 * @param <T> the type of the internal input
 * @param <R> the type of the external output
 */
public interface AbstractResponseGenerator<T, R>  {

    R generateResponse(T internalInput);
}
