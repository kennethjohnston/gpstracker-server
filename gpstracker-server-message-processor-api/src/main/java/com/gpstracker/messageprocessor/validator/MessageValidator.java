package com.gpstracker.messageprocessor.validator;

import com.gpstracker.model.external.input.gps.GPSLocation;

public interface MessageValidator {

	public boolean validateMessage(GPSLocation gpsLocation);
}