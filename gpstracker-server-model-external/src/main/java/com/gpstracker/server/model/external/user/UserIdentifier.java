package com.gpstracker.server.model.external.user;

import com.gpstracker.server.model.external.ExternalEntity;

public class UserIdentifier extends ExternalEntity {
    
    /** The user ID associated with the user. */
    private String userId;
    /** The user name of the user. */
    private String userName;
    
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
    
    /**
     * Get the user name.
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Set the user name.
     * 
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
