package com.gpstracker.server.input.handler;

import java.util.List;

import com.gpstracker.server.input.handler.api.ExternalInputHandler;
import com.gpstracker.server.input.handler.api.MessageParser;
import com.gpstracker.server.input.handler.api.MessageValidator;

/**
 * An abstract implementation of the input message handler that defines a template of how 
 * the external input should be processed.
 *
 * @param <T> the type of the external input
 * @param <R> the type of the external output
 * @param <S> the type of the internal representation of the input
 */
public abstract class AbstractInputHandler<T, R, S> implements ExternalInputHandler<T, R> {

    private List<MessageValidator<T>> messageValidators;
    private MessageParser<T> messageParser;
    
    /**
     * Takes as input 
     */
    @Override
    public R handleInputMessage(T message) {
        R response = null;
        if (isValidate(message)) {
            S internalMessage = parseExternalMessage(message);
            response = processInternalMessage(internalMessage);
        } else {
            response = generateInvalidInputResponse();

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
     * @return
     */
    protected abstract R generateInvalidInputResponse();
        
    /**
     * 
     * @param internalMessage
     * @return
     */
    protected abstract R processInternalMessage(S internalMessage);
    
    /**
     * 
     * @param message
     * @return
     */
    protected abstract S parseExternalMessage(T message);
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Get message validator.
     * @return the messageValidators
     */
    public List<MessageValidator<T>> getMessageValidators() {
        return messageValidators;
    }

    /**
     * Set message validators.
     * @param messageValidators the messageValidators to set
     */
    public void setMessageValidators(List<MessageValidator<T>> messageValidators) {
        this.messageValidators = messageValidators;
    }

    /**
     * Get message parser.
     * @return the messageParser
     */
    public MessageParser<T> getMessageParser() {
        return messageParser;
    }

    /**
     * Set message parser.
     * @param messageParser the messageParser to set
     */
    public void setMessageParser(MessageParser<T> messageParser) {
        this.messageParser = messageParser;
    }
}
