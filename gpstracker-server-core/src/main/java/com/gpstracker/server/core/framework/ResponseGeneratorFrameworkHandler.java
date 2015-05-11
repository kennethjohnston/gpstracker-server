package com.gpstracker.server.core.framework;

import com.gpstracker.server.api.response.generator.ResponseGenerator;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;

public class ResponseGeneratorFrameworkHandler extends AbstractInternalFrameworkHandler {

    /** The response generator. */
    private ResponseGenerator<? super InternalEntity, ? super ExternalEntity> responseGenerator;

    /**
     * Handles the business logic processing for the response generator.
     * 
     * @param argument the input argument
     * @return the response from processing
     */
    @Override
    protected Object handleProcessing(Object argument) {
        return responseGenerator.generateResponse((InternalEntity) argument);
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Sets the responseGenerator.
     * 
     * @return the responseGenerator
     */
    public ResponseGenerator<? super InternalEntity, ? super ExternalEntity> getResponseGenerator() {
        return responseGenerator;
    }

    /**
     * Gets the responseGenerator.
     * 
     * @param responseGenerator the responseGenerator to set
     */
    public void setResponseGenerator(ResponseGenerator<? super InternalEntity, ? super ExternalEntity> responseGenerator) {
        this.responseGenerator = responseGenerator;
    }
}
