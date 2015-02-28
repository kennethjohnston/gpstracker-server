package com.gpstracker.server.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.gpstracker.messageprocessor.api.GpsMessageProcessor;
import com.gpstracker.server.input.conveter.GpsLocationExternalInputConverter;
import com.gpstracker.server.model.external.input.gps.GPSLocation;
import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;

/**
 * GPS Location Webservice.
 */
@WebService 
public class GpsLocationService {
	
	private GpsMessageProcessor messageProcessor;
	private GpsLocationExternalInputConverter externalInputConveter;
	
	/**
	 * Web service that handles the GPS location requests.
	 * 
	 * @param gpsLocation the external gps location input
	 * @return true if the request was successful, false otherwise
	 */
	@WebMethod
	public boolean gpsLocationRQ(final @WebParam(name="gpsLocation") GPSLocation gpsLocation) {
		GPSCoordinates gpsCoordinates = externalInputConveter.convert(gpsLocation);
		
		boolean success = false;
		if (gpsCoordinates != null) {
			success = messageProcessor.processGpsCoordinates(gpsCoordinates);
		}
		
		return success;
	}

	//---------------------------------------------------------------------------------------------
	// Getter and Setter methods
	/**
	 * Gets the message processor.
	 * 
	 * @return the messageProcessor
	 */
	@WebMethod(exclude=true)
	public GpsMessageProcessor getMessageProcessor() {
		return messageProcessor;
	}

	/**
	 * Sets the message processor.
	 * 
	 * @param messageProcessor the messageProcessor to set
	 */
	@WebMethod(exclude=true)
	public void setMessageProcessor(final GpsMessageProcessor messageProcessor) {
		this.messageProcessor = messageProcessor;
	}

	/**
	 * Gets the external input converter.
	 * 
	 * @return the external input converter
	 */
	@WebMethod(exclude=true)
	public GpsLocationExternalInputConverter getExternalInputConveter() {
		return externalInputConveter;
	}

	/**
	 * Sets the external input converter.
	 * 
	 * @param externalInputConveter the converter to set
	 */
	@WebMethod(exclude=true)
	public void setExternalInputConveter(final GpsLocationExternalInputConverter externalInputConveter) {
		this.externalInputConveter = externalInputConveter;
	}	
}
