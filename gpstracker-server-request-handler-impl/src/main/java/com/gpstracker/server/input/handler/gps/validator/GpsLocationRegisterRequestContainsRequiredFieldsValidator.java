package com.gpstracker.server.input.handler.gps.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gpstracker.server.api.input.handler.ExternalInputValidator;
import com.gpstracker.server.model.external.ErrorCode;
import com.gpstracker.server.model.external.ErrorCodeType;
import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;

public class GpsLocationRegisterRequestContainsRequiredFieldsValidator implements ExternalInputValidator<UserGpsLocationRegisterRequest> {

    @Override
    public List<ErrorCode> validateMessage(final UserGpsLocationRegisterRequest message) {
        List<ErrorCode> errorCodes = new ArrayList<ErrorCode>();
        
        if (message.getUserIdentifier() == null)  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "User identifier missing"));
        } else {
            if (StringUtils.isBlank(message.getUserIdentifier().getUserId()))  {
                errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Associated user id missing"));
            }
            if (StringUtils.isBlank(message.getUserIdentifier().getUserName()))  {
                errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Associated user name missing"));
            }
        }
        
        if (message.getGpsLocation() == null)  {
            errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "GPS data missing"));
        } else {        
            if (StringUtils.isBlank(message.getGpsLocation().getLatitude()))  {
                errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Latitude missing"));
            }        
            if (StringUtils.isBlank(message.getGpsLocation().getLongitude()))  {
                errorCodes.add(new ErrorCode(ErrorCodeType.MISSING_INPUT, "Longitude missing"));
            }
        }
        
        return errorCodes;
    }
}
