package com.gpstracker.server.service.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.gpstracker.server.model.internal.mq.InternalMessage;
import com.gpstracker.server.service.mq.api.MessageQueueService;

/**
 * Spring JMS implemetnation of the message queue service, this implementation will
 * rely on the Spring JMS template for pushing messages to the MQ.
 */
public class DefaultMessageQueueService implements MessageQueueService {
    
    private static final Logger LOGGER = Logger.getLogger("MessageQueue");
    private JmsTemplate jmsTemplate;
    private Queue queue;
    
    /**
     * Pushes a message to the default queue.
     * 
     * @param message the message to push
     * @return true if the message was successfully pushed, false otherwise
     */
    @Override
    public boolean pushMesssage(InternalMessage message) {
        return pushMesssage(message, queue);
    }

    /**
     * Pushes a a message to the specified queue. 
     * 
     * @param message the message to push
     * @param distinationQueue the destination queue of message
     * @return true if the message was successfully pushed, false otherwise
     */
    @Override
    public boolean pushMesssage(final InternalMessage message, final String distinationQueueName) {
        jmsTemplate.send(
                distinationQueueName,
                new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(message);
                    }});
        
        return true;
    }
    
    /**
     * Pushes a a message to the specified queue. 
     * 
     * @param message the message to push
     * @param distinationQueueName the name of the destination queue of message
     * @return true if the message was successfully pushed, false otherwise
     */
    @Override
    public boolean pushMesssage(final InternalMessage message, final Queue distinationQueue) {        
        jmsTemplate.send(
                this.queue, 
                new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(message);
                    }});

        return false;
    }
    
    /**
     * Pulls a message from the default queue. The message pulled from the queue
     * will typically be controlled by the message queue implementation which typically
     * uses a FiFo approach.
     * 
     * @return the next message in the queue
     */
    @Override
    public InternalMessage pullMessage() {
        InternalMessage internalMessage = null;
        try {
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive();
            internalMessage = (InternalMessage) message.getObject();
        } catch (JMSException ex) {
            LOGGER.error("Error occurred while pulling message from queue: " + ex);
        }
        
        return internalMessage;
    }

    /**
     * Pulls a message from the specified queue. The message pulled from the queue
     * will typically be controlled by the message queue implementation which typically
     * uses a FiFo approach.
     * 
     * @param sourceQueue the the source queue
     * @return the next message in the queue
     */
    @Override
    public InternalMessage pullMessage(Queue sourceQueue) {
        InternalMessage internalMessage = null;
        try {
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive(sourceQueue);
            internalMessage = (InternalMessage) message.getObject();
        } catch (JMSException ex) {
            LOGGER.error("Error occurred while pulling message from queue: " + ex);
        }
        
        return internalMessage;
    }
    
    /**
     * Pulls a message from the specified queue. The message pulled from the queue
     * will typically be controlled by the message queue implementation which typically
     * uses a FiFo approach.
     * 
     * @param sourceQueueName the name of the source queue
     * @return the next message in the queue
     */
    @Override
    public InternalMessage pullMessage(String sourceQueueName) {
        InternalMessage internalMessage = null;
        try {
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive(sourceQueueName);
            internalMessage = (InternalMessage) message.getObject();
        } catch (JMSException ex) {
            LOGGER.error("Error occurred while pulling message from queue: " + ex);
        }
        
        return internalMessage;
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * Gets the jmsTemplate.
     * 
     * @return the jmsTemplate
     */
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    /**
     * Sets the jmsTemplate.
     * 
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
