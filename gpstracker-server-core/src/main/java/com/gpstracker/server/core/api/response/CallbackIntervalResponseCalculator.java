package com.gpstracker.server.core.api.response;

import com.gpstracker.server.core.api.CoreOperation;

/**
 * Defines the callback interval response calculator functionality. A callback interval response calculator should
 * calculate when a client should callback for the response to a request. The functionality is intended to support
 * asynchronous request/response for client-server communication. The
 */
public interface CallbackIntervalResponseCalculator extends CoreOperation {

	/**
	 * Calculates the time interval in milli-seconds on when a client should call
	 * back for a response.
	 * @return
	 */
	long caculatedCallbackInterval();

}
