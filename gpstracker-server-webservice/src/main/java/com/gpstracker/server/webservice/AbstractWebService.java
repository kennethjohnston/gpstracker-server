package com.gpstracker.server.webservice;

import javax.jws.WebMethod;

import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;

import com.gpstracker.server.api.core.InternalFrameworkHandler;
import com.gpstracker.server.api.core.ThroughputMonitor;
import com.gpstracker.server.core.monitor.LocalStatefulThroughputMonitor;
import com.gpstracker.server.model.external.request.AbstractUserRequest;
import com.gpstracker.server.model.external.response.AbstractUserResponse;
import com.gpstracker.server.model.internal.ProcessingContext;
import com.gpstracker.server.model.internal.ProcessingStageType;

/**
 * Defines an abstract web service that handles user requests and delegates to a framework handler.
 * 
 * @param <T> the type of request to process
 * @param <R> the type of response to return
 */
public abstract class AbstractWebService<T extends AbstractUserRequest, R extends AbstractUserResponse> {

    /** Logger. */
    private static final Logger LOGGER = Logger.getLogger(AbstractWebService.class);
    /** The user registration request handler. */
    private InternalFrameworkHandler handler;
        
    /**
     * Web service that handles the GPS location requests.
     * 
     * @param gpsLocationthe external gps location input
     * @return true if the request was successful, false otherwise
     */
    public R handleRequest(final T request) {
        LOGGER.info("Recieved Request \n\n");
        ProcessingContext context = createProcessingContext(request);
        
        return (R) handler.handle(context, request);
    }

    
    //--------------------------------------------------------------------------------------------- 
    /**
     * Creates a processing context that will be used to determine how the application is to be processed.
     * @param request 
     * 
     * @return the processing context associated with the request.
     */
    protected ProcessingContext createProcessingContext(final AbstractUserRequest request) {
        ProcessingContext context = new ProcessingContext();        
        context.setAsynchronousCallbackSupported(request.isCallBackAllowed());
        context.setProcessingStartTime(LocalDateTime.now());
        context.setProcessingStage(ProcessingStageType.REQUEST_RECIEVED);
        
        return context;
    }

    // ---------------------------------------------------------------------------------------------
    // Getter and Setter methods
    /**
     * Gets the internal framework handler.
     * 
     * @return the internal framework handler.
     */
    @WebMethod(exclude = true)
    public InternalFrameworkHandler getHandler() {
        return handler;
    }

    /**
     * Sets the internal framework handler.
     * 
     * @param handler internal framework handler to set
     */
    @WebMethod(exclude = true)
    public void setHandler(final InternalFrameworkHandler handler) {
        this.handler = handler;
    }
}
