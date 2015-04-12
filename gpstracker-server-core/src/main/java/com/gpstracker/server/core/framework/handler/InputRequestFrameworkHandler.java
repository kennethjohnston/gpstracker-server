package com.gpstracker.server.core.framework.handler;

import com.gpstracker.server.api.input.handler.ExternalInputHandler;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;

public class InputRequestFrameworkHandler extends AbstractFrameworkHandler {

    private ExternalInputHandler<? super ExternalEntity, ? super InternalEntity> inputHandler;

    @Override
    protected Object handleProcessing(Object argument) {
        return inputHandler.handleInputMessage((ExternalEntity)argument);
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the inputHandler
     */
    public ExternalInputHandler<? super ExternalEntity, ? super InternalEntity> getInputHandler() {
        return inputHandler;
    }

    /**
     * @param inputHandler the inputHandler to set
     */
    public void setInputHandler(ExternalInputHandler<? super ExternalEntity, ? super InternalEntity> inputHandler) {
        this.inputHandler = inputHandler;
    }
}
