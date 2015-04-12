package com.gpstracker.server.model.internal.request;

import com.gpstracker.server.model.internal.InternalEntity;

public class UserLogin extends InternalEntity {

    private static final long serialVersionUID = 1L;
    /** The user name. */
    private String userName;
    /** The password. */
    private String password;
    
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
}
