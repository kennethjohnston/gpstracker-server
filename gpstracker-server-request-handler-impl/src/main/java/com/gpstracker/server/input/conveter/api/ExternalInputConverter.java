package com.gpstracker.server.input.conveter.api;

/**
 * 
 * @param <T> the type of the external input object
 * @param <R> the type of the internal output object
 */
public interface ExternalInputConverter<T, R> {

	R convert(T externalInput);
}
