package com.gpstracker.messageprocessor.validator;

import com.gpstracker.model.external.GPSLocation;

public interface MessageValidator {

	public boolean validateMessage(GPSLocation gpsLocation);
}
