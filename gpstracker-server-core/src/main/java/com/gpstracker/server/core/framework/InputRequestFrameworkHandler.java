package com.gpstracker.server.core.framework;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;

public class InputRequestFrameworkHandler extends AbstractInternalFrameworkHandler {

    private ExternalInputHandler<? super ExternalEntity, ? super InternalEntity> inputHandler;

    /**
     * Handles the business logic processing for the input request handler.
     * 
     * @param argument the input argument
     * @return the response from processing
     */
    @Override
    protected Object handleProcessing(final Object argument) {
        return inputHandler.handleInputMessage((ExternalEntity)argument);
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Gets the inputHandler.
     * 
     * @return the inputHandler
     */
    public ExternalInputHandler<? super ExternalEntity, ? super InternalEntity> getInputHandler() {
        return inputHandler;
    }

    /**
     * Sets the inputHandler.
     * 
     * @param inputHandler the inputHandler to set
     */
    public void setInputHandler(ExternalInputHandler<? super ExternalEntity, ? super InternalEntity> inputHandler) {
        this.inputHandler = inputHandler;
    }
}
