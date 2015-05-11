package com.gpstracker.server.api.messageprocessor.businessrules;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessingOperation;
import com.gpstracker.server.model.internal.result.AbstractProcessingResult;

public interface BusinessRulesProcessor<T extends AbstractProcessingResult, R extends AbstractProcessingResult> 
        extends InternalMessageProcessingOperation {
    
    R processBusinessRules(T result);
}
