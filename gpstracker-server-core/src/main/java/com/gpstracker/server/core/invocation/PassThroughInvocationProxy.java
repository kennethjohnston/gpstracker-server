package com.gpstracker.server.core.invocation;

import com.gpstracker.server.core.api.InvocationProxy;

/**
 * The invocation proxy implementation will capture the invocation, the proxy will simply invoke the method call on
 * the same thread of execution. 
 * 
 * This implementation is designed to be used to support asynchronous processing using message queue through JMS.
 */
public class PassThroughInvocationProxy implements InvocationProxy {
	
	@Override
	public Object invoke() {
		// TODO Auto-generated method stub
		return null;
	}

}
