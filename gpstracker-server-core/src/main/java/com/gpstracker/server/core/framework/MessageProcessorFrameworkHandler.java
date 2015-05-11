package com.gpstracker.server.core.framework;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.InternalEntity;

public class MessageProcessorFrameworkHandler extends AbstractInternalFrameworkHandler {
    
    private InternalMessageProcessor<? super InternalEntity, ? super InternalEntity> processor;

    /**
     * Handles the business logic processing for the message processor.
     * 
     * @param argument the input argument
     * @return the response from processing
     */
    @Override
    protected Object handleProcessing(Object argument) {
        return processor.processMessage((InternalEntity) argument);
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Gets the processor.
     * 
     * @return the processor
     */
    public InternalMessageProcessor<? super InternalEntity, ? super InternalEntity> getProcessor() {
        return processor;
    }

    /**
     * Sets the processor.
     * 
     * @param processor the processor to set
     */
    public void setProcessor(InternalMessageProcessor<? super InternalEntity, ? super InternalEntity> processor) {
        this.processor = processor;
    }    
}
