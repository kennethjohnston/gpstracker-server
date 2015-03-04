package com.gpstracker.sever.model.internal.common;



import org.joda.time.LocalDate;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * Represents the user 
 */
public class User extends InternalEntity {
	
	private long userId;
	private String userName;
	private String userPhoneNumber;
	private String userEmailAddress;
	private LocalDate userRegistrationDate;
	
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
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
	 * @return the userPhoneNumber
	 */
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	
	/**
	 * @param userPhoneNumber the userPhoneNumber to set
	 */
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	/**
	 * @return the userEmailAddress
	 */
	public String getUserEmailAddress() {
		return userEmailAddress;
	}
	
	/**
	 * @param userEmailAddress the userEmailAddress to set
	 */
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	/**
	 * @return the userRegistrationDate
	 */
	public LocalDate getUserRegistrationDate() {
		return userRegistrationDate;
	}

	/**
	 * @param userRegistrationDate the userRegistrationDate to set
	 */
	public void setUserRegistrationDate(LocalDate userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}
}
