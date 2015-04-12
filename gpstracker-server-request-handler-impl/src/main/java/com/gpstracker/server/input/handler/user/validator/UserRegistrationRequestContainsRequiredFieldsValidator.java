package com.gpstracker.server.input.handler.user.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gpstracker.server.api.input.handler.ExternalInputValidator;
import com.gpstracker.server.model.external.ErrorCode;
import com.gpstracker.server.model.external.ErrorCodeType;
import com.gpstracker.server.model.external.request.UserRegistrationRequest;

public class UserRegistrationRequestContainsRequiredFieldsValidator implements ExternalInputValidator<UserRegistrationRequest> {

    @Override
    public List<ErrorCode> validateMessage(final UserRegistrationRequest message) {
        List<ErrorCode> errorCodes = new ArrayList<ErrorCode>();
        
        if (StringUtils.isBlank(message.getUserName()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "User name missing"));
        }
        if (StringUtils.isBlank(message.getPassword()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Passwor missing"));
        } 
        if (StringUtils.isBlank(message.getEmailAddress()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Email address missing"));
        } 
        if (StringUtils.isBlank(message.getPhoneNumber()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Phone number missing"));
        }
        
        return errorCodes;
    }
}
