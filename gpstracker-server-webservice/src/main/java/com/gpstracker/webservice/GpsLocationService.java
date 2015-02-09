package com.gpstracker.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gpstracker.messageprocessor.GpsMessageProcessor;
import com.gpstracker.model.external.GPSLocation;
import com.gpstracker.model.internal.GPSCoordinates;

@WebService
public class GpsLocationService {
	private GpsMessageProcessor messageProcessor = new GpsMessageProcessor();

	@WebMethod
	public boolean gpsLocationRQ(@WebParam(name="gpsLocation") GPSLocation gpsLocation) {
		GPSCoordinates gpsCoordinates = new GPSCoordinates();
		//gpsCoordinates.setLatitude(Double.valueOf(gpsLocation.getLatitude()));
		//gpsCoordinates.setLongitude(Double.valueOf(gpsLocation.getLongitude()));

		return messageProcessor.processGpsCoordinates(gpsCoordinates);
	}
}
