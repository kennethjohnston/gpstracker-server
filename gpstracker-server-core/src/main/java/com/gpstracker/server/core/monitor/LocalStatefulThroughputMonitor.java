package com.gpstracker.server.core.monitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import com.gpstracker.server.api.core.ThroughputMonitor;

/**
 * A local stateful throughput monitor provides a localised representation of the throughput of a single instance, with the
 * information based on the the duration of the application is running. If the application is restarted then the current
 * state is lost, and the statistics will be based on the duration of the applications life.
 *
 * A local stateful monitor will provide fast processing as their is no I/O and data is stored in memory. It is only applicable
 * if all servers are running on a similar infrastructure/resource with a similar distribution of load. 
 */
public class LocalStatefulThroughputMonitor implements ThroughputMonitor {

    /** Singleton instance of the through put monitor. */
    public LocalStatefulThroughputMonitor INSTANCE = new LocalStatefulThroughputMonitor();
    /** Counts the operations received. */    
    private AtomicLong operationsRecieved = new AtomicLong(0);
    /** Counts the operations completed. */    
    private AtomicLong operationsCompleted = new AtomicLong(0);
    /**
     *  Executor service for processing requests on an isolated thread. This is
     *  to allow separate worker threads to manage the statistics instead of forcing the
     *  calling thread to be side-tracked processing the statistic updates.
     */
    private ExecutorService requestWorker = Executors.newFixedThreadPool(50);
    
    
    /**
     * Non-public constructor to support singleton usage.
     */
    protected LocalStatefulThroughputMonitor() {
    }

    @Override
    public long getOutstandingMessageRequestCount() {
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
