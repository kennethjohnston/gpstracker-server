package com.gpstracker.server.model.internal.gps;

import java.util.List;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * An internal representation of a global position.
 */
public class GlobalPositionList extends InternalEntity {

    private static final long serialVersionUID = 1L;
    
    /** List of global positions.  */
    private List<GlobalPosition> globalPositionList;

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
