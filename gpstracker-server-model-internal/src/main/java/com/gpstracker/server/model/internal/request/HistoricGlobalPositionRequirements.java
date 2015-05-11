package com.gpstracker.server.model.internal.request;

import org.joda.time.DateTime;

import com.gpstracker.server.model.internal.InternalEntity;

public class HistoricGlobalPositionRequirements extends InternalEntity {
    
    private static final long serialVersionUID = 1L;
    /** The user Id. */
    private String userId;
    /** The user name. */
    private String userName;
    /** The start date range. */
    private DateTime startDateTime;
    /** The end date range. */
    private DateTime endDateTime;
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
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
     * @return the startDateTime
     */
    public DateTime getStartDateTime() {
        return startDateTime;
    }
    /**
     * @param startDateTime the startDateTime to set
     */
    public void setStartDateTime(DateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    /**
     * @return the endDateTime
     */
    public DateTime getEndDateTime() {
        return endDateTime;
    }
    /**
     * @param endDateTime the endDateTime to set
     */
    public void setEndDateTime(DateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    

}
