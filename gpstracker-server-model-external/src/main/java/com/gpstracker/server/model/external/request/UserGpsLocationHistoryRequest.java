package com.gpstracker.server.model.external.request;

/**
 * 
 */
public class UserGpsLocationHistoryRequest extends AbstractUserRequest {
    
    /** Serial version Id. */
    private static final long serialVersionUID = 7980359986116577567L;
    /** The start date range. */
    private String startDate;
    /** The end time. */
    private String startTime;
    /** The end date range. */
    private String endDate;
    /** The end time. */
    private String endTime;
    
    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }
    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }
    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}
