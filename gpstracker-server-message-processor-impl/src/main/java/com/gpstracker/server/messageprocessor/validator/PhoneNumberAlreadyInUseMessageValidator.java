/*
 * GPS Tracker Server Application.
 */
package com.gpstracker.server.messageprocessor.validator;

import com.gpstracker.server.api.messageprocessor.validator.GlobalPositionValidator;
import com.gpstracker.server.model.internal.gps.GlobalPosition;

/**
 * 
 */
public class PhoneNumberAlreadyInUseMessageValidator implements GlobalPositionValidator {

    @Override
    public boolean validateMessage(final GlobalPosition globalPosition) {
        // TODO Auto-generated method stub
        return false;
    }

}
