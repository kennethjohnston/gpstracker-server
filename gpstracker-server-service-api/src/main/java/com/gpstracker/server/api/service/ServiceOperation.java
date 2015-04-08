package com.gpstracker.server.api.service;

/**
 * Defines a service layer operation of the application, all other service operations should be a derivative of this operation.
 * 
 * Service operations can be called from any other layer. As a result, the service operations should not dependent on any other
 * layer of the application - this is to avoid circular dependencies on packages. The only allowed dependency of the service layer
 * is the external and internal model.
 */
public interface ServiceOperation {

}
