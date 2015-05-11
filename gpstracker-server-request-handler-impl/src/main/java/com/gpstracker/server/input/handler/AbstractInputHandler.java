package com.gpstracker.server.input.handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.api.input.handler.ExternalInputValidator;
import com.gpstracker.server.model.external.ErrorCode;

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
        List<ErrorCode> errorList = validate(message);
        if (CollectionUtils.isEmpty(errorList)) {
            response = convertToInternal(message);
        } else {
            handleInvalidInput(message, errorList);
            throw new RuntimeException("Invalid input recieved.");
        }
        
        return response;
    }
        
    //---------------------------------------------------------------------------------------------
    /**
     * Determines if the input message is valid. The validity is determined by the 
     * configure validators. If no validators are specified then the message is considered
     * logically valid. If any of the validators considers the message invalidate, then it
     * the message will be flagged as invalid.
     * 
     * @param message
     * @return
     */
    protected List<ErrorCode> validate(T message) {
        List<ErrorCode> errorList = new ArrayList<ErrorCode>();
        if (CollectionUtils.isEmpty(messageValidators)) {
            return errorList;
        }
        
        for (ExternalInputValidator<T> validator : messageValidators) {
            errorList.addAll(validator.validateMessage(message));            
        }
        
        return errorList;
    }

    /**
     * Convert external request to internal object.
     *  
     * @param message the external input message
     * @return the internal object
     */
    protected R convertToInternal(T message) {
        return converter.convert(message);
    }      
    
    /**
     * Handles invalid data passed in.
     * 
     * @param message
     * @param errorList 
     */
    protected void handleInvalidInput(T message, List<ErrorCode> errorList) {
        // Hook method that can be overridden by subclasses.
    }
    
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
     * Gets the external input converter.
     * 
     * @return the converter
     */
    public ExternalInputConverter<T, R> getConverter() {
        return converter;
    }

    /**
     * Sets the external input converter.
     * 
     * @param converter the converter to set
     */
    public void setConverter(ExternalInputConverter<T, R> converter) {
        this.converter = converter;
    }
}
