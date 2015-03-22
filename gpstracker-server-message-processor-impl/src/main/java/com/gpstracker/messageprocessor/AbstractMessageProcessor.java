package com.gpstracker.messageprocessor;

import java.util.List;

import com.gpstracker.messageprocessor.api.InternalMessageProcessor;
import com.gpstracker.messageprocessor.parser.api.MessageParser;
import com.gpstracker.messageprocessor.validator.api.MessageValidator;

/**
 * An abstract implementation of the internal message processor.
 *
 * @param <T> the type of the message to process
 * @param <R> the type of the response
 */
public abstract class AbstractMessageProcessor<T, R> implements InternalMessageProcessor<T> {

    /** The message validators. */
    private List<MessageValidator<T>> messageValidators;
    /** The message parser. */
    private MessageParser<T> messageParser;

    @Override
    public void processMessage(final T message) {
        if (isValidate(message)) {

        }

        R internalMessage = parse(message);
    }

    // ---------------------------------------------------------------------------------------------
    // Abstract Method Definitions
    protected abstract boolean isValidate(T message);

    protected abstract R parse(T message);

    // ---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the messageValidators
     */
    public List<MessageValidator<T>> getMessageValidators() {
        return messageValidators;
    }

    /**
     * Set the message validators.
     *
     * @param messageValidators the messageValidators to set
     */
    public void setMessageValidators(final List<MessageValidator<T>> messageValidators) {
        this.messageValidators = messageValidators;
    }

    /**
     * @return the messageParser
     */
    public MessageParser getMessageParser() {
        return messageParser;
    }

    /**
     * @param messageParser
     *            the messageParser to set
     */
    public void setMessageParser(MessageParser messageParser) {
        this.messageParser = messageParser;
    }
}
