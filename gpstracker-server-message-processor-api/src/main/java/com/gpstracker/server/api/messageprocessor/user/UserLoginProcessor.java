package com.gpstracker.server.api.messageprocessor.user;

import com.gpstracker.server.api.messageprocessor.InternalMessageProcessor;
import com.gpstracker.server.model.internal.request.UserLogin;
import com.gpstracker.server.model.internal.result.UserLoginProcessingResult;

public interface UserLoginProcessor extends InternalMessageProcessor<UserLogin, UserLoginProcessingResult> {

}
