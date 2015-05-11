package com.gpstracker.server.model.internal.result;

import com.gpstracker.server.model.internal.user.User;

public class UserLoginProcessingResult extends AbstractProcessingResult {
    
    /** Serialisation Id. */
    private static final long serialVersionUID = -8776531258590193429L;
    /** The user associated with the login request. */
    private User user;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
