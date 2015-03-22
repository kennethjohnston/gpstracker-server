package com.gpstracker.server.core.invocation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.gpstracker.server.core.api.InvocationProxy;

/**
 * Abstract invocation proxy. Defines standard and common structure for a standard invocation proxy.
 */
@Aspect
public class GpsMessageProcesserInvocationProxy implements InvocationProxy {
    
    private String targetCall;

    @Override
    @Pointcut("execution(* com.gpstracker.messageprocessor.api.GpsMessageProcessor.processGpsCoordinates(..))")
    //@Pointcut("execution(* com.gpstracker.messageprocessor.GpsMessageLoggerProcessor.processGpsCoordinates(..))")
    public Object invoke() {
        // TODO Auto-generated method stub
        return null;
    }
    
    //---------------------------------------------------------------------------------------------
    // Getters and Setters

}
