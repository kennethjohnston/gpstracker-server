package com.gpstracker.server.service.mq.api;

import javax.jms.Queue;

import com.gpstracker.server.model.internal.mq.InternalMessage;

/**
 * Defines the functionality of a message queue service. The responsibility of the service will be to
 * place messages on the required message queue.
 */
public interface MessageQueueService extends MessageQueueServiceOperation {
    
    /**
     * Pushes a message to the default queue.
     * 
     * @param message the message to push
     * @return true if the message was successfully pushed, false otherwise
     */
    boolean pushMesssage(InternalMessage message);
    
    /**
     * Pushes a a message to the specified queue. 
     * 
     * @param message the message to push
     * @param distinationQueue the destination queue of message
     * @return true if the message was successfully pushed, false otherwise
     */
    boolean pushMesssage(InternalMessage message, Queue distinationQueue);
    
    /**
     * Pushes a a message to the specified queue. 
     * 
     * @param message the message to push
     * @param distinationQueueName the name of the destination queue of message
     * @return true if the message was successfully pushed, false otherwise
     */
    boolean pushMesssage(InternalMessage message, String distinationQueueName);
    
    /**
     * Pulls a message from the default queue. The message pulled from the queue
     * will typically be controlled by the message queue implementation which typically
     * uses a FiFo approach.
     * 
     * @return the next message in the queue
     */
    InternalMessage pullMessage();
    
    /**
     * Pulls a message from the specified queue. The message pulled from the queue
     * will typically be controlled by the message queue implementation which typically
     * uses a FiFo approach.
     * 
     * @param sourceQueue the the source queue
     * @return the next message in the queue
     */
    InternalMessage pullMessage(Queue sourceQueue);
    
    /**
     * Pulls a message from the specified queue. The message pulled from the queue
     * will typically be controlled by the message queue implementation which typically
     * uses a FiFo approach.
     * 
     * @param sourceQueueName the name of the source queue
     * @return the next message in the queue
     */
    InternalMessage pullMessage(String sourceQueueName);

}
