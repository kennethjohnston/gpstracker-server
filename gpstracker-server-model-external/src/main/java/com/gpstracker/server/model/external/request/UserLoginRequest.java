package com.gpstracker.server.model.external.request;

/**
 * Represents a user login request.
 */
public class UserLoginRequest extends AbstractUserRequest {

    /** The password. */
    private String password;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters       
    /**
     * 
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
     
}
