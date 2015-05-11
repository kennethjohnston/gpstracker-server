package com.gpstracker.server.messageprocessor;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.api.messageprocessor.businessrules.BusinessRulesProcessor;
import com.gpstracker.server.api.messageprocessor.validator.MessageValidator;
import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.result.AbstractProcessingResult;

/**
 * An abstract implementation of the internal message processor.
 *
 * @param <T> the type of the message to process
 * @param <R> the type of the result from processing
 */
public abstract class AbstractMessageProcessor<T extends InternalEntity, R extends AbstractProcessingResult>
        implements InternalMessageProcessor<T, R> {

    /** The static Logger. */
    private static Logger LOGGER = Logger.getLogger("InternalProcessorLog");
    /** List of validators used to valid the message. */
    private List<MessageValidator<T>> validators;
    /** The business logic processors. */
    private List<BusinessRulesProcessor<R, R>> businessRulesProcessors;

    /**
     * Process the internal message.
     *
     * @param message the internal entity message
     * @return the processing processing result
     */
    @Override
    public R processMessage(final T message) {
        if (isInputValid(message) == false) {
            throw new IllegalArgumentException("Invalid internal input recieved: " + message);
        }

        R result = createInitialResult(message);
        return processBusinessRules(result);
    }

    /**
     * Determines if the input message is valid, the validity of the message is based.
     * on the message validators that are configured.
     *
     * @param message the internal input message
     * @return true if the message is valid, false otherwise.
     */
    protected boolean isInputValid(final T message) {
        boolean isValid = true;
        if (CollectionUtils.isEmpty(validators)) {
            return isValid;
        }

        for (MessageValidator<T> validator : validators) {
            isValid = validator.validateMessage(message);
            if (isValid == false) {
                break;
            }
        }

        return isValid;
    }

    /**
     * Process message specific processing.
     *
     * @param result the initial processing result
     * @return the processing result
     */
    protected R processBusinessRules(final R result) {
        R processedResult = result;
        if (CollectionUtils.isEmpty(businessRulesProcessors)) {
            return processedResult;
        }

        for (BusinessRulesProcessor<R, R> processor : businessRulesProcessors) {
            processedResult = processor.processBusinessRules(processedResult);
        }

        return processedResult;
    }

    //---------------------------------------------------------------------------------------------
    // Abstract method definitions
    /**
     * Abstract factor method to create the initial processing results. 
     * 
     * @param message the input message
     * @return the initial processing results
     */
    protected abstract R createInitialResult(final T message);

    //---------------------------------------------------------------------------------------------
    // Getters and Setters 
    /**
     * @return the validators
     */
    public List<MessageValidator<T>> getValidators() {
        return validators;
    }

    /**
     * @param validators the validators to set
     */
    public void setValidators(List<MessageValidator<T>> validators) {
        this.validators = validators;
    }

    /**
     * @return the businessRulesProcessors
     */
    public List<BusinessRulesProcessor<R, R>> getBusinessRulesProcessors() {
        return businessRulesProcessors;
    }

    /**
     * @param businessRulesProcessors the businessRulesProcessors to set
     */
    public void setBusinessRulesProcessors(List<BusinessRulesProcessor<R, R>> businessRulesProcessors) {
        this.businessRulesProcessors = businessRulesProcessors;
    }
}
