package com.gpstracker.server.model.internal.user;

import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.gps.GlobalPositionList;

public class UserGlobalPositionHistory extends InternalEntity {

    /** User. */
    private User user;
    /** Global positions list. */
    private GlobalPositionList globalPositionList;
    
    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * @return the globalPositionList
     */
    public GlobalPositionList getGlobalPositionList() {
        return globalPositionList;
    }
    /**
     * @param globalPositionList the globalPositionList to set
     */
    public void setGlobalPositionList(GlobalPositionList globalPositionList) {
        this.globalPositionList = globalPositionList;
    }    
}
