package com.gpstracker.server.core.api;

/**
 * Defines an architecture handler of the application. The concept of the application is that the core will control
 * the flow of the application. The core handlers are intrusive and help control the flow of the application.
 * 
 * It is intended that the handler be associated with an invocation proxy, where the invocation proxy will capture a 
 * an invocation and delegate to a hanlder.
 */
public interface InternalFrameworkHandler {

}
