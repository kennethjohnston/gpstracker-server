package com.gpstracker.server.core.monitor;

import java.util.concurrent.atomic.AtomicLong;

import com.gpstracker.server.core.api.ThroughputMonitor;

/**
 * A local stateful throughput monitor provides a localised representation of the throughput of a single instance, with the
 * information based on the the duration of the application is running. If the application is restarted then the current
 * state is lost, and the statistics will be based on the duration of the applications life.
 *
 * A local stateful monitor will provide fast processing as their is no I/O and data is stored in memory. It is only applicable
 * if all servers are running on a similar infrastructure and have similar
 */
public class LocalStatefulThroughputMonitor implements ThroughputMonitor {

	/** Singleton instance of the through put monitor. */
	public LocalStatefulThroughputMonitor INSTANCE = new LocalStatefulThroughputMonitor();
	/** . */	
	private AtomicLong operationsRecieved = new AtomicLong(0);

	/**
	 * Non-public constructor.
	 */
	protected LocalStatefulThroughputMonitor() {
	}

	@Override
	public long getOutstandingMessageRequetCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getOperationRequestFrequencyPerSecond() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getOperationProcessedFrequencyPerSecond() {
		// TODO Auto-generated method stub
		return 0;
	}
 }
