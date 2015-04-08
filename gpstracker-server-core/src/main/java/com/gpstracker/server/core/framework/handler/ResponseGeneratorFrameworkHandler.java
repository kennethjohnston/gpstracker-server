package com.gpstracker.server.core.framework.handler;

import com.gpstracker.server.api.response.generator.ResponseGenerator;
import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.internal.InternalEntity;

public class ResponseGeneratorFrameworkHandler extends AbstractFrameworkHandler {

    private ResponseGenerator<? super InternalEntity, ? super ExternalEntity> responseGenerator;

    @Override
    protected Object handleProcessing(Object argument) {
        return responseGenerator.generateResponse((InternalEntity) argument);
    }

    /**
     * @return the responseGenerator
     */
    public ResponseGenerator<? super InternalEntity, ? super ExternalEntity> getResponseGenerator() {
        return responseGenerator;
    }

    /**
     * @param responseGenerator the responseGenerator to set
     */
    public void setResponseGenerator(ResponseGenerator<? super InternalEntity, ? super ExternalEntity> responseGenerator) {
        this.responseGenerator = responseGenerator;
    }
}
