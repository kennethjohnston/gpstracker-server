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

    /** A unique Id to indentify the callback request. */
    private long uniqueId;
    /** The interval for the client to wait before calling back. */
    private long callbackInterval;
    /** The callback authenication key. This key is authenicate the callback is no high-jacked. */
    private long authenicationCallbackKey;

    /**
     * Default constructor.
     */
    public CallbackResponse() {

    }

    /**
     * Argument based constructor.
     * @param uniqueId the unique id
     * @param callbackInterval the call back interval in milli-seconds
     * @param authenicationCallbackKey the authentication key
     */
    public CallbackResponse(long uniqueId, long callbackInterval, long authenicationCallbackKey) {
        this.uniqueId = uniqueId;
        this.callbackInterval = callbackInterval;
        this.authenicationCallbackKey = authenicationCallbackKey;
    }

    /**
     * @return the uniqueId
     */
    public long getUniqueId() {
        return uniqueId;
    }

    /**
     * @param uniqueId the uniqueId to set
     */
    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
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

    /**
     * @return the authenicationCallbackKey
     */
    public long getAuthenicationCallbackKey() {
        return authenicationCallbackKey;
    }

    /**
     * @param authenicationCallbackKey the authenicationCallbackKey to set
     */
    public void setAuthenicationCallbackKey(long authenicationCallbackKey) {
        this.authenicationCallbackKey = authenicationCallbackKey;
    }
}
