package com.gpstracker.server.core.framework.handler;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.InternalEntity;

public class MessageProcessorFrameworkHandler extends AbstractFrameworkHandler {
    
    private InternalMessageProcessor<? super InternalEntity, ? super InternalEntity> processor;

    @Override
    protected Object handleProcessing(Object argument) {
        return processor.processMessage((InternalEntity) argument);
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the processor
     */
    public InternalMessageProcessor<? super InternalEntity, ? super InternalEntity> getProcessor() {
        return processor;
    }

    /**
     * @param processor the processor to set
     */
    public void setProcessor(InternalMessageProcessor<? super InternalEntity, ? super InternalEntity> processor) {
        this.processor = processor;
    }    
}
