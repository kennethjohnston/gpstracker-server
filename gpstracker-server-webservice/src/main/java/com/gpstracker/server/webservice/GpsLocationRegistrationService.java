package com.gpstracker.server.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.request.UserGpsLocationRegisterRequest;
import com.gpstracker.server.model.external.response.CallbackResponse;
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
     * @param userGpsLocationRegistrationRequest the external gps location registration request
     * @return the user GPS location response, may contain a callback response.
     */
    @WebMethod
    public UserGpsLocationResponse registerLocation(final UserGpsLocationRegisterRequest userGpsLocationRegistrationRequest) {
        ExternalEntity reponse = super.handleRequest(userGpsLocationRegistrationRequest);
        if (reponse instanceof CallbackResponse) {
            UserGpsLocationResponse userGpsLocationResponse = new UserGpsLocationResponse();
            userGpsLocationResponse.setCallBackResponse((CallbackResponse) reponse);
            userGpsLocationResponse.setSuccessful(true);
            reponse = userGpsLocationResponse;
        }
        
        return (UserGpsLocationResponse) reponse;
    }
    
    /**
     * Web service that handles the GPS location requests.
     * 
     * @param userGpsLocationRegistrationRequest the external gps location registration request
     * @return the user GPS location response, may contain a callback response. 
     */
    public UserGpsLocationResponse registerLocationResultCallback(final UserGpsLocationRegisterRequest userGpsLocationRegistrationRequest) {
        return (UserGpsLocationResponse) super.handleCallback(userGpsLocationRegistrationRequest);
    } 
}
