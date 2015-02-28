package com.gpstracker.messageprocessor.validator.user;

import com.gpstracker.messageprocessor.validator.api.GpsMessageValidator;
import com.gpstracker.messageprocessor.validator.api.MessageValidator;
import com.gpstracker.server.model.external.input.gps.GPSLocation;
import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;

public class UserNameMessageValidator implements GpsMessageValidator {

	@Override
	public boolean validateMessage(GPSCoordinates gpsCoordinates) {
		// TODO Auto-generated method stub
		return false;
	}

}
