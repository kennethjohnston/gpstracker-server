package com.gpstracker.server.model.external.response;

import com.gpstracker.server.model.external.ExternalEntity;

/**
 * Representation a callback response which can be sent back to a client to indicate when it should callback to collect
 * the response.
 *
 * A callback response should only be required for a client request that requires a significant amount of processing, or
 * when the application is under a heavy load. Before relying on the callback functionality it should be determined if a
 * callback response is the most efficient way of processing the client's request. Consideration should also be allowed
 * for the client no calling back for the response.
 */
public class CallbackResponse extends ExternalEntity {

    /** Serial version Id. */
    private static final long serialVersionUID = -4315686836361066298L;
    /** A unique callback response Id to identify the callback request. */
    private String callbackResponseId;
    /** The interval for the client to wait before calling back. */
    private long callbackInterval;
   
    /**
     * Default constructor.
     */
    public CallbackResponse() {

    }
    
    /**
     * Default constructor.
     */
    public CallbackResponse(final String callbackResponseId, final long callbackInterval) {
        this.callbackResponseId = callbackResponseId;
        this.callbackInterval = callbackInterval;
    }

    //---------------------------------------------------------------------------------------------
    // 
    /**
     * @return the callbackResponseId
     */
    public String getCallbackResponseId() {
        return callbackResponseId;
    }

    /**
     * @param callbackResponseId the callbackResponseId to set
     */
    public void setCallbackResponseId(String callbackResponseId) {
        this.callbackResponseId = callbackResponseId;
    }

    /**
     * @return the callbackInterval
     */
    public long getCallbackInterval() {
        return callbackInterval;
    }

    /**
     * @param callbackInterval the callbackInterval to set
     */
    public void setCallbackInterval(long callbackInterval) {
        this.callbackInterval = callbackInterval;
    }
}
