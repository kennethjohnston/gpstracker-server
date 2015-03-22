package com.gpstracker.server.model.internal;

import java.io.Serializable;

/**
 * Represents an internal model entity. All internal objects should extend from this internal representation, 
 * as the expectation is that this  high level object will allow for abstractions rather than concrete dependencies.
 * 
 */
public abstract class InternalEntity implements Serializable {

    private static final long serialVersionUID = -2325105380332128976L;

}
