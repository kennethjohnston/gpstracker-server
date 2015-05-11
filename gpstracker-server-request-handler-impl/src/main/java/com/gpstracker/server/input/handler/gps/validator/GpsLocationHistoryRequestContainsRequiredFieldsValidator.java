package com.gpstracker.server.input.handler.gps.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gpstracker.server.api.input.handler.ExternalInputValidator;
import com.gpstracker.server.model.external.ErrorCode;
import com.gpstracker.server.model.external.ErrorCodeType;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;

public class GpsLocationHistoryRequestContainsRequiredFieldsValidator implements ExternalInputValidator<UserGpsLocationHistoryRequest> {

    @Override
    public List<ErrorCode> validateMessage(final UserGpsLocationHistoryRequest message) {
        List<ErrorCode> errorCodes = new ArrayList<ErrorCode>();
        
        if (message.getUserIdentifier() == null)  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "User identifier missing"));
        } else {
            if (StringUtils.isBlank(message.getUserIdentifier().getUserId()))  {
                errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Associated user id missing"));
            }            
        }
        if (StringUtils.isBlank(message.getStartDate()))  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Start date missing"));
        }        
        if (StringUtils.isBlank(message.getEndDate())) {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "End date missing"));
        }
        
        return errorCodes;
    }

}
