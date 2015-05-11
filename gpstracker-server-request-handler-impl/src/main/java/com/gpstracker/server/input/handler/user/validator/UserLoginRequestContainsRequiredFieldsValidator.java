package com.gpstracker.server.input.handler.user.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gpstracker.server.api.input.handler.ExternalInputValidator;
import com.gpstracker.server.model.external.ErrorCode;
import com.gpstracker.server.model.external.ErrorCodeType;
import com.gpstracker.server.model.external.request.UserLoginRequest;

public class UserLoginRequestContainsRequiredFieldsValidator implements ExternalInputValidator<UserLoginRequest> {

    @Override
    public List<ErrorCode> validateMessage(final UserLoginRequest message) {
        List<ErrorCode> errorCodes = new ArrayList<ErrorCode>();
        
        if (StringUtils.isBlank(message.getUserName()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "User name missing"));
        } 
        
        if (StringUtils.isBlank(message.getPassword()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Password missing"));
        }        
        
        return errorCodes;
    }
}
