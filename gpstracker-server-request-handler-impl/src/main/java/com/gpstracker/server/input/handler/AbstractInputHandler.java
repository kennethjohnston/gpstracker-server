package com.gpstracker.server.input.handler;

import java.util.List;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.api.input.handler.ExternalInputValidator;

/**
 * An abstract implementation of the input message handler that defines a template of how 
 * the external input should be processed.
 *
 * @param <T> the type of the external input
 * @param <R> the type of the external output
 */
public abstract class AbstractInputHandler<T, R> implements ExternalInputHandler<T, R> {

    /** The validator of the external message. */
    private List<ExternalInputValidator<T>> messageValidators;
    /** The external to internal converter. */
    private ExternalInputConverter<T, R> converter;
    
    /**
     * Takes as input 
     */
    @Override
    public R handleInputMessage(final T message) {
        R response = null;
        if (isValidate(message)) {
            response = convertToInternal(message);
        }
        
        return response;        
    }
    
    //---------------------------------------------------------------------------------------------
    // Abstract Method Definitions
    /**
     * 
     * @param message
     * @return
     */
    protected abstract boolean isValidate(T message);
    
    /**
     * 
     * @param message
     * @return
     */
    protected abstract R convertToInternal(T message);
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Get message validator.
     * 
     * @return the messageValidators
     */
    public List<ExternalInputValidator<T>> getMessageValidators() {
        return messageValidators;
    }

    /**
     * Set message validators.
     * 
     * @param messageValidators the messageValidators to set
     */
    public void setMessageValidators(List<ExternalInputValidator<T>> messageValidators) {
        this.messageValidators = messageValidators;
    }

    /**
     * @return the converter
     */
    public ExternalInputConverter<T, R> getConverter() {
        return converter;
    }

    /**
     * @param converter the converter to set
     */
    public void setConverter(ExternalInputConverter<T, R> converter) {
        this.converter = converter;
    }
}
