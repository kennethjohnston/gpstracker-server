package com.gpstracker.server.model.internal.user;

import com.gpstracker.server.model.internal.InternalEntity;
import com.gpstracker.server.model.internal.gps.GlobalPosition;

/**
 * Represents a user's global position.
 */
public class UserGlobalPosition extends InternalEntity {
    
    /** The use assoicated with the global position. */
    private long userId;
    /** The global position. */
    private GlobalPosition globalPosition;

    /**
     *  Default constructor.
     */
    public UserGlobalPosition() {
    }
    
    /**
     * Argument constructor to initialise object.
     * 
     * @param userId the user id
     * @param globalPosition the global position
     */
    public UserGlobalPosition(final long userId, final GlobalPosition globalPosition) {
       this.userId = userId;
       this.globalPosition = globalPosition;
    }
    
    /**
     * @return the user Id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param user the user to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the globalPosition
     */
    public GlobalPosition getGlobalPosition() {
        if (globalPosition == null) {
            globalPosition = new GlobalPosition();
        }
        return globalPosition;
    }

    /**
     * @param globalPosition the globalPosition to set
     */
    public void setGlobalPosition(GlobalPosition globalPosition) {
        this.globalPosition = globalPosition;
    }
}
