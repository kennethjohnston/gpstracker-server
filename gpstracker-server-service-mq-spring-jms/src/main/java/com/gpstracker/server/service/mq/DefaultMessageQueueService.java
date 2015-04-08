package com.gpstracker.server.service.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.gpstracker.server.model.internal.mq.InternalMessage;
import com.gpstracker.server.service.mq.api.MessageQueueService;

/**
 * 
 * 
 */
public class DefaultMessageQueueService implements MessageQueueService {
    
    /**
     * 
     */
    private JmsTemplate jmsTemplate;
    private Queue queue;
    
    @Override
    public boolean pushMesssage(InternalMessage message) {
        return pushMesssage(message, queue);
    }

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
    

    @Override
    public InternalMessage pullMessage() {
        InternalMessage internalMessage = null;
        try {
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive();
            internalMessage = (InternalMessage) message.getObject();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return internalMessage;
    }

    @Override
    public InternalMessage pullMessage(Queue sourceQueue) {
        InternalMessage internalMessage = null;
        try {
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive(sourceQueue);
            internalMessage = (InternalMessage) message.getObject();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return internalMessage;
    }
    
    @Override
    public InternalMessage pullMessage(String sourceQueueName) {
        InternalMessage internalMessage = null;
        try {
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive(sourceQueueName);
            internalMessage = (InternalMessage) message.getObject();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return internalMessage;
    }
    
    //---------------------------------------------------------------------------------------------
    // 
    public Message createMessage(InternalMessage message) {
        return null;    
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the jmsTemplate
     */
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    /**
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
