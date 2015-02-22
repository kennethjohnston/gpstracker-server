package com.gpstracker.server.core.invocation;

import javax.jms.Queue;

import com.gpstracker.server.core.api.InvocationProxy;
import com.gpstracker.server.service.mq.api.MessageQueueService;

/**
 * The invocation proxy implementation will capture the invocation, however, instead of processing the request. The request will
 * place on a message queue. The associated listener will then process the invocation when resources are avaialbe.
 * 
 * This implementation is designed to be used to support asynchronous processing using message queue through JMS.
 */
public class MessageQueueDelegationInvocationProxy implements InvocationProxy {
	
	private MessageQueueService mqService;	
	private Queue targetQueue;	
	private String messageType;

	@Override
	public Object invoke() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//---------------------------------------------------------------------------------------------
	// Getters and Setters

}
