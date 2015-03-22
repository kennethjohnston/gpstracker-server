package com.gpstracker.server.model.external.request;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 * 
 */
public class UserRegistrationRequest extends ExternalEntity {
    
    private String userName;
    private String password;
    private String phoneNumber;
    private String macAddress;
    private String ipAddress;
    private String country;

}
