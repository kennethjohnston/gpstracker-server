package com.gpstracker.server.model.internal.gps;

import java.util.List;

import com.gpstracker.server.model.internal.InternalEntity;

/**
 * An internal representation of a global position.
 */
public class GlobalPositionList extends InternalEntity {
    
    /** List of global positions.  */
    private List<GlobalPosition> globalPositionList;
}
