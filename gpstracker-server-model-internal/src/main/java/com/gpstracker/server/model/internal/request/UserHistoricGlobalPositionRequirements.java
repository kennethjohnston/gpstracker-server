package com.gpstracker.server.model.internal.request;

import org.joda.time.DateTime;

import com.gpstracker.server.model.internal.InternalEntity;

public class UserHistoricGlobalPositionRequirements extends InternalEntity {
    
    private static final long serialVersionUID = 1L;
    /** The start date range. */
    private DateTime startDateTime;
    /** The end date range. */
    private DateTime endDateTime;
    
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
