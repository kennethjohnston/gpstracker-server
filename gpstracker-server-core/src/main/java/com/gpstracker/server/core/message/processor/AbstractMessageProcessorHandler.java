package com.gpstracker.server.core.message.processor;

import com.gpstracker.server.model.internal.mq.InternalMessage;

/**
 * Core operation that process a message. The processing will be delegated to an implementation of the processor-api. However, the core
 * will control the flow of processing. 
 */
public class AbstractMessageProcessorHandler {
    
    public void handleMessageRequest(InternalMessage message) {
        
    }

}
