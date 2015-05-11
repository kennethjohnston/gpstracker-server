package com.gpstracker.server.model.external.request;

/**
 * Represents a user login request.
 */
public class UserLoginRequest extends AbstractUserRequest {

    /** Serial version Id. */
    private static final long serialVersionUID = 1529210413931811365L;
    /** Required user name. */
    private String userName;
    /** The password. */
    private String password;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters  
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
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
