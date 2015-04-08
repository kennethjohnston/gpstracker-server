package com.gpstracker.server.messageprocessor;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.result.AbstractProcessingResult;

/**
 * An abstract implementation of the internal message processor.
 *
 * @param <T> the type of the message to process
 * @param <R> the type of the result from processing
 */
public abstract class AbstractMessageProcessor<T extends InternalEntity, R extends AbstractProcessingResult> implements InternalMessageProcessor<T, R> {

    @Override
    public R processMessage(final T message) {
 
        return processInternal(message);
    }

    //---------------------------------------------------------------------------------------------
    // Abstract Method Definitions
    protected abstract R processInternal(final T message);
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters 
}
