package com.gpstracker.server.model.internal.mq;

import java.io.Serializable;

import com.gpstracker.server.model.internal.InternalEntity;


/**
 * Represents an internal message transmitted between layers of the application.
 */
public class InternalMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private InternalMessageType messageType;
    private InternalEntity messageContent;
        
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
     * @return the messageContent
     */
    public InternalEntity getMessageContent() {
        return messageContent;
    }
    /**
     * @param messageContent the messageContent to set
     */
    public void setMessageContent(InternalEntity messageContent) {
        this.messageContent = messageContent;
    }
}