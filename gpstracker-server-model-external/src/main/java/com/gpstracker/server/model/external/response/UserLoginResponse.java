package com.gpstracker.server.model.external.response;

import com.gpstracker.server.model.external.user.UserIdentifier;


public class UserLoginResponse extends RawUserResponse {

    /** Serial version Id. */   
    private static final long serialVersionUID = 8538984093587857184L;
    /** The user unique Id. */
    private UserIdentifier userIdentifier;
    
    /**
     * @return the userId
     */
    public UserIdentifier getUserIdentifier() {
        return userIdentifier;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserIdentifier(final UserIdentifier userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
