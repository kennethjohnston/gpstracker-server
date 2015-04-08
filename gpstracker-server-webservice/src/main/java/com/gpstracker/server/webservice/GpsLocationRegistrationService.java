package com.gpstracker.server.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;
import com.gpstracker.server.model.external.response.UserGpsLocationResponse;

/**
 * The web service that defines a web service to support users registering their GPS locations. The
 * processing is delegated to the super implementation.
 */
@WebService 
public class GpsLocationRegistrationService extends AbstractWebService<UserGpsLocationRegisterRequest, UserGpsLocationResponse> {

    /**
     * Web service that handles the GPS location requests.
     * 
     * @param gpsLocation the external gps location input
     * @return true if the request was successful, false otherwise
     */
    @WebMethod
    public UserGpsLocationResponse registerLocation(final UserGpsLocationRegisterRequest userGpsLocationRegistrationRequest) {
        return super.handleRequest(userGpsLocationRegistrationRequest) ;
    }  
}
