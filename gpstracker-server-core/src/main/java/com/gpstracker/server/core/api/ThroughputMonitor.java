package com.gpstracker.server.core.api;

/**
 * Defines the throughput monitor functionality. A throughput monitor should monitor
 * incoming requests and provide runtime statistics of the message processing and the
 * frequency of message throughput.
 *
 * A throughput monitor should, ideally, offer information across all running instances, therefore
 * an implementation should take into consideration other instance of the application. A mutual
 * data store may be required to share throughput data information.
 *
 * It is expected that each running instance of the application should have one instance
 * of the throughput monitor. It is recommended that an implementation be a singleton, and
 * be thread-safe. Consideration should also be made to ensure that monitor implementation
 * does not become a bottleneck for message processing. The data store should be ideally stored
 * in fast access memory such as a distributed memory cache. The monitor implementation should
 * also allow for an single being stop/started and still be able to provide accurate statistics.
 */
public interface ThroughputMonitor extends CoreOperation {

	/**
	 * Gets the number of processing operations that are currently outstanding.
	 *
	 * @return the number of outstanding operations
	 */
	long getOutstandingMessageRequetCount();

	/**
	 * Gets the frequency of operations received by the application per second.
	 * @return
	 */
	long getOperationRequestFrequencyPerSecond();

	/**
	 * Gets the frequency of operations processed by the application per second.
	 * @return
	 */
	long getOperationProcessedFrequencyPerSecond();
}
