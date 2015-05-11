package com.gpstracker.server.model.internal.gps;

import java.util.List;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * An internal representation of a global position.
 */
public class GlobalPositionList extends InternalEntity {

    /** List of global positions.  */
    private List<GlobalPosition> globalPositionList;

    /**
     * Default constructor.
     */
    public GlobalPositionList() {
        
    }
    
    /**
     * Argument constructor.
     * 
     * @param globalPositionList global position list
     */
    public GlobalPositionList(List<GlobalPosition> globalPositionList) {
        this.globalPositionList = globalPositionList;
    }
     
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the globalPositionList
     */
    public List<GlobalPosition> getGlobalPositionList() {
        return globalPositionList;
    }

    /**
     * @param globalPositionList the globalPositionList to set
     */
    public void setGlobalPositionList(List<GlobalPosition> globalPositionList) {
        this.globalPositionList = globalPositionList;
    }
}
