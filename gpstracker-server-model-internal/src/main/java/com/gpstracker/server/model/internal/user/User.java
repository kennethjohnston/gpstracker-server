package com.gpstracker.server.model.internal.user;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * Represents the user 
 */
public class User extends InternalEntity {
    
    /** Serial version Id. */
    private static final long serialVersionUID = -8454091627271863223L;
    private String userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private DateTime registrationDate;
    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
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
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the userPhoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * @param userPhoneNumber the userPhoneNumber to set
     */
    public void setPhoneNumber(String userPhoneNumber) {
        this.phoneNumber = userPhoneNumber;
    }
    
    /**
     * @return the userEmailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * @param userEmailAddress the userEmailAddress to set
     */
    public void setEmailAddress(String userEmailAddress) {
        this.emailAddress = userEmailAddress;
    }

    /**
     * @return the userRegistrationDate
     */
    public DateTime getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param userRegistrationDate the userRegistrationDate to set
     */
    public void setRegistrationDate(DateTime userRegistrationDate) {
        this.registrationDate = userRegistrationDate;
    }
}
