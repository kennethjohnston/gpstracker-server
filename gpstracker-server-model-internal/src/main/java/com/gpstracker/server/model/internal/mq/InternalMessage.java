package com.gpstracker.server.model.internal.mq;

import java.io.Serializable;

import com.gpstracker.server.model.internal.ProcessingContext;


/**
 * Represents an internal message transmitted between layers of the application.
 */
public class InternalMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private InternalMessageType messageType;
    private ProcessingContext processingContext;
    private Object messageContent;
        
    /**
     * Default constructor.
     */
    public InternalMessage() {
        
    }
    
    /**
     * Argument constructor.
     */
    public InternalMessage(
            final ProcessingContext processingContext,
            final Object messageContent) {
        this.processingContext = processingContext;
        this.messageContent = messageContent;
    }
    
    /**
     * Argument constructor.
     */
    public InternalMessage(
            final InternalMessageType internalMessageType,
            final ProcessingContext processingContext,
            final Object messageContent) {
        this.messageType = internalMessageType;
        this.processingContext = processingContext;
        this.messageContent = messageContent;
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the messageType
     */
    public InternalMessageType getMessageType() {
        return messageType;
    }
    
    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(InternalMessageType messageType) {
        this.messageType = messageType;
    }
    
    /**
     * @return the processingContext
     */
    public ProcessingContext getProcessingContext() {
        return processingContext;
    }

    /**
     * @param processingContext the processingContext to set
     */
    public void setProcessingContext(ProcessingContext processingContext) {
        this.processingContext = processingContext;
    }
    
    /**
     * @return the messageContent
     */
    public Object getMessageContent() {
        return messageContent;
    }
    /**
     * @param messageContent the messageContent to set
     */
    public void setMessageContent(Object messageContent) {
        this.messageContent = messageContent;
    }
}