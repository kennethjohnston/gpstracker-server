package com.gpstracker.messageprocessor.api;

public interface InternalMessageProcessor<T> extends InternalMessageProcessingOperation {
    
    void processMessage(T message);
}
