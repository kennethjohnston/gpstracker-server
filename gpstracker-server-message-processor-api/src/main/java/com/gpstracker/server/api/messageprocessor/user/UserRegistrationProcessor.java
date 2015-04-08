package com.gpstracker.server.api.messageprocessor.user;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.request.UserRegistration;
import com.gpstracker.server.model.internal.result.UserRegistrationProcessingResult;

public interface UserRegistrationProcessor extends InternalMessageProcessor<UserRegistration, UserRegistrationProcessingResult> {

}
