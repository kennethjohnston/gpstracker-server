package com.gpstracker.server.api.core;

/**
 * Defines the function of the invocation proxy. A invocation proxy purpose is to capture
 * method calls and, if required, adjust how the invocation is handled.
 *
 * This can allow for method call to be re-invoked in a more suitable style. For example,
 * the invocation of the method call could invoke the method call on a separate thread, or
 * pass the method call to execution service.
 *
 * This functionality maybe be created using third framework or APIs, however, it is important that
 * there usage be implemented via this interface so the application's architecture is aware
 * of any invocation proxying.
 */
public interface InvocationProxy extends CoreOperation {

    /**
     * Handles the invocation of a proxied method.
     * 
     * @return the response from the invocation
     */
    public Object invoke();

}
