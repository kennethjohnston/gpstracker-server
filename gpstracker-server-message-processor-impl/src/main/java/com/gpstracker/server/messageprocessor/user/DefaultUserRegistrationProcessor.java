package com.gpstracker.server.messageprocessor.user;

import com.gpstracker.server.api.messageprocessor.user.UserRegistrationProcessor;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.request.UserRegistration;
import com.gpstracker.server.model.internal.result.UserRegistrationProcessingResult;

/**
 * The default implementation of how user registrations should be processed.
 */
public class DefaultUserRegistrationProcessor extends AbstractMessageProcessor<UserRegistration, UserRegistrationProcessingResult> implements UserRegistrationProcessor {

    @Override
    protected UserRegistrationProcessingResult processInternal(final UserRegistration message) {
        // TODO Auto-generated method stub
        return new UserRegistrationProcessingResult();
    }
}
