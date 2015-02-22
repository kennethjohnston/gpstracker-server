package com.gpstracker.server.service.mq.api;

import javax.jms.Message;
import javax.jms.Queue;

import com.gpstracker.server.service.api.ServiceOperation;

/**
 * Defines the functionality of a message queue service. The responsibility of the service will be to
 * place messages on the required message queue.
 */
public interface MessageQueueService extends ServiceOperation {
	
	/**
	 * Pushes a message to the default queue.
	 * 
	 * @param message the message to push
	 * @return true if the message was successfully pushed, false otherwise
	 */
	boolean pushMesssage(Message message);
	
	/**
	 * Pushes a a message to the specified queue. 
	 * @param message the message to push
	 * @param distinationQueue the distination queue of message
	 * @return true if the message was successfully pushed, false otherwise
	 */
	boolean pushMesssage(Message message, Queue distinationQueue);
	
	/**
	 * Pulls a message from the default queue. The message pulled from the queue
	 * will typically be controlled by the message queue implementation which typically
	 * uses a FiFo approach.
	 * @return the next message in the queue
	 */
	Message pullMessage();
	
	/**
	 * Pulls a message from the specified queue. The message pulled from the queue
	 * will typically be controlled by the message queue implementation which typically
	 * uses a FiFo approach.
	 * @return the next message in the queue
	 */
	Message pullMessage(Queue sourceQueue);

}
