package com.gpstracker.server.model.external.response;

import java.util.List;

import com.gpstracker.server.model.external.ExternalEntity;

public class UserRegistrationResponse extends AbstractUserResponse {
    
    private boolean successfulRegistation;
    private List<String> errors;

}
