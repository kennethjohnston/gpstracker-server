package com.gpstracker.server.messageprocessor.user;

import com.gpstracker.server.api.messageprocessor.user.UserLoginProcessor;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.request.UserLogin;
import com.gpstracker.server.model.internal.result.UserLoginProcessingResult;

/**
 * The default implementation of how user login should be processed.
 */
public class DefaultUserLoginProcessor extends AbstractMessageProcessor<UserLogin, UserLoginProcessingResult> implements UserLoginProcessor {

    @Override
    protected UserLoginProcessingResult processInternal(UserLogin message) {
        // TODO Auto-generated method stub
        return null;
    }

}
