package com.gpstracker.server.api.messageprocessor;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * 
 * @param <T> the type of input the processor should process
 * @param <R> the type of output the processor should return
 */
public interface InternalMessageProcessor<T extends InternalEntity, R extends InternalEntity> extends InternalMessageProcessingOperation {
    
    R processMessage(T message);
}
