package com.gpstracker.server.model.external.request;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.user.UserIdentifier;

public abstract class AbstractUserRequest extends ExternalEntity {
    
    /** The user identifier. */
    private UserIdentifier userIdentifier;
    /** The token provided to the user when they logged in. */
    private String authenticationToken;
    /** The device name. */
    private String deviceName;
    /** Indicates if callback is supported. */
    private boolean callBackAllowed;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
}
