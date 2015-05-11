package com.gpstracker.server.model.external.request;


/**
 * 
 */
public class UserRegistrationRequest extends AbstractUserRequest {
    
    /** Serial version Id. */
    private static final long serialVersionUID = -2053215755885206952L;
    /** Required user name. */
    private String userName;
    /** The specified password. */
    private String password;
    /** The user phone number. */
    private String phoneNumber;
    /** The user email address. */
    private String emailAddress;   
    /** The user country. */
    private String country;
    
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
