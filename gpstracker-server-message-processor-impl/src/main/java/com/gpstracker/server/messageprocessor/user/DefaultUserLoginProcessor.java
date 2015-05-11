package com.gpstracker.server.messageprocessor.user;

import org.apache.commons.lang3.StringUtils;

import com.gpstracker.server.api.messageprocessor.user.UserLoginProcessor;
import com.gpstracker.server.api.service.user.UserService;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.request.UserLogin;
import com.gpstracker.server.model.internal.result.UserLoginProcessingResult;
import com.gpstracker.server.model.internal.user.User;

/**
 * The default implementation of how user login should be processed.
 */
public class DefaultUserLoginProcessor extends AbstractMessageProcessor<UserLogin, UserLoginProcessingResult> implements UserLoginProcessor {

    /** The User service. */
    private UserService userService;

    @Override
    protected UserLoginProcessingResult createInitialResult(final UserLogin userLogin) {
        UserLoginProcessingResult result = new UserLoginProcessingResult();

        User user = userService.loadByUserName(userLogin.getUserName());
        if (user == null) {
            result.addError("User not found");
        } else {
            if (StringUtils.equals(user.getPassword(), userLogin.getPassword())) {
                result.setUser(user);
            } else {
                result.addError("Invalid password");
            }
        }

        return result;
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
