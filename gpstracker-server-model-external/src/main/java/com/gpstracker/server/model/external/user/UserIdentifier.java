package com.gpstracker.server.model.external.user;

import com.gpstracker.server.model.external.ExternalEntity;

public class UserIdentifier extends ExternalEntity {
    
    /** Serial version Id. */   
    private static final long serialVersionUID = -7304304785356246558L;
    /** The user ID associated with the user. */
    private String userId;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * Get the user ID.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Set the user ID.
     * 
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
