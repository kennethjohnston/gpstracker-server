package com.gpstracker.server.api.core;

/**
 * Defines a core operation of the application, all other core operation should be a derivative of this operation.
 *
 * Core operation should not be called upon, but used only control the flow of processing, and utilise dependency inversion.
 * Core operation should define the application architecture and processing flow.
 */
public interface CoreOperation {

}
