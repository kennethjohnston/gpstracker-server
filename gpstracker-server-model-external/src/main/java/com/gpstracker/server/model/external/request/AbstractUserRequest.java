package com.gpstracker.server.model.external.request;

import com.gpstracker.server.model.external.ExternalEntity;
import com.gpstracker.server.model.external.user.UserIdentifier;

public abstract class AbstractUserRequest extends ExternalEntity {
    
    /** Serial version Id. */
    private static final long serialVersionUID = -8956093311451684684L;
    /** The user identifier. */
    private UserIdentifier userIdentifier;
    /** Indicates if callback is supported. */
    private boolean callBackAllowed;
    /** The callback Id. */
    private String callBackToken;
    
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

    /**
     * @return the callBackToken
     */
    public String getCallBackToken() {
        return callBackToken;
    }

    /**
     * @param callBackToken the callBackToken to set
     */
    public void setCallBackToken(String callBackToken) {
        this.callBackToken = callBackToken;
    }    
}
