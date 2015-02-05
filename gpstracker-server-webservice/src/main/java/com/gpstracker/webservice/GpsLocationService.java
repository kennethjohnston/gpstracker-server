package com.gpstracker.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gpstracker.common.model.internal.GPSLocation;

@WebService
public class GpsLocationService {

	@WebMethod
	public boolean gpsLocationRQ(GPSLocation gpsLocation) {
		System.out.print(gpsLocation);
		return true;
	}
}
