package com.gpstracker.server.api.core;

/**
 * Defines the functionality of a resource manager. The resource manager should be responsible for loading and managing
 * any resources the application uses.
 *
 * Any classes dependent on resources should not be responsible for loading or managing them, instead the classes should
 * register with the resource manager which update them if/when required. The resource manager can then be responsible for
 * how and where resources are loaded/taken from.
 *
 * To ensure the core operation is not being called by a lower level operation the implementation should follow an approach
 * similar to the observer pattern.The resource manager should contain a list of observer that implement an operation that will
 * support them to be called polymorphically by the resource manager.
 */
public interface ResourceManager extends CoreOperation {

}
