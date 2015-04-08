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
    /**
     * @return the userIdentifier
     */
    public UserIdentifier getUserIdentifier() {
        return userIdentifier;
    }
    
    /**
     * @param userIdentifier the userIdentifier to set
     */
    public void setUserIdentifier(UserIdentifier userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
    
    /**
     * @return the authenticationToken
     */
    public String getAuthenticationToken() {
        return authenticationToken;
    }
    
    /**
     * @param authenticationToken the authenticationToken to set
     */
    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }
    
    /**
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }
    
    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    
    /**
     * @return the callBackAllowed
     */
    public boolean isCallBackAllowed() {
        return callBackAllowed;
    }
    
    /**
     * @param callBackAllowed the callBackAllowed to set
     */
    public void setCallBackAllowed(boolean callBackAllowed) {
        this.callBackAllowed = callBackAllowed;
    }    
}
