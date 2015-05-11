package com.gpstracker.server.messageprocessor.user;

import java.util.UUID;

import org.joda.time.DateTime;

import com.gpstracker.server.api.messageprocessor.user.UserRegistrationProcessor;
import com.gpstracker.server.api.service.user.UserService;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.request.UserRegistration;
import com.gpstracker.server.model.internal.result.UserRegistrationProcessingResult;
import com.gpstracker.server.model.internal.user.User;

/**
 * The default implementation of how user registrations should be processed.
 */
public class DefaultUserRegistrationProcessor extends AbstractMessageProcessor<UserRegistration, UserRegistrationProcessingResult> implements UserRegistrationProcessor {

    /** The User service. */
    private UserService userService;
    
    @Override
    protected UserRegistrationProcessingResult createInitialResult(final UserRegistration message) {
        UserRegistrationProcessingResult result = new UserRegistrationProcessingResult();

        User existingUser = userService.loadByUserName(message.getUserName());
        if (existingUser != null) {
            result.setSucessfullyProcessed(false);
            result.addError("User name already taken");
        } else {
            User newUser = new User();
            newUser.setUserId(UUID.randomUUID().toString());
            newUser.setUserName(message.getUserName());
            newUser.setPassword(message.getPassword());
            newUser.setEmailAddress(message.getEmailAddress());
            newUser.setPhoneNumber(message.getPhoneNumber());
            if (userService.store(newUser)) {
                result.setSucessfullyProcessed(true);
            }
        }

        return result;
    }

    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }
}
