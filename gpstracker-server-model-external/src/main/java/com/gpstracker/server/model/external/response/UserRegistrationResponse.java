package com.gpstracker.server.model.external.response;

public class UserRegistrationResponse extends RawUserResponse {
    
    /** Serial version Id. */   
    private static final long serialVersionUID = 1L;
    /** Confirmation of the registered user name. */
    private String username;    
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
