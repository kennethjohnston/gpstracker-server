package com.gpstracker.server.model.external.request;

/**
 * Represents a user login request.
 */
public class UserLoginRequest extends AbstractUserRequest {

    /** The user name. */
    private String userName;
    /** The password. */
    private String password;
    /** The device Id. */
    private String deviceId;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters    
    /**
     * 
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * 
     * 
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
    
    /**
     * 
     * 
     * @return the deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }
    
    /**
     * 
     * 
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }    
}
