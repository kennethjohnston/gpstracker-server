package com.gpstracker.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gpstracker.messageprocessor.GpsMessageLoggerProcessor;
import com.gpstracker.model.external.input.gps.GPSLocation;
import com.gpstracker.model.internal.input.gps.GPSCoordinates;

@WebService 
public class GpsLocationService {
	private GpsMessageLoggerProcessor messageProcessor = new GpsMessageLoggerProcessor();

	@WebMethod
	public boolean gpsLocationRQ(@WebParam(name="gpsLocation") GPSLocation gpsLocation) {
		GPSCoordinates gpsCoordinates = new GPSCoordinates();

		gpsCoordinates.setLatitude(Double.valueOf(gpsLocation.getLatitude()));
		gpsCoordinates.setLongitude(Double.valueOf(gpsLocation.getLongitude()));

		return messageProcessor.processGpsCoordinates(gpsCoordinates);
	}
}
