package com.gpstracker.server.model.external;

import java.io.Serializable;

/**
 * Represents an external model entity. All external objects/input should extend from this external
 * representation, as the expectation is that this high level object will allow for abstractions 
 * rather than concrete dependencies.
 */
public abstract class ExternalEntity implements Serializable {

}
