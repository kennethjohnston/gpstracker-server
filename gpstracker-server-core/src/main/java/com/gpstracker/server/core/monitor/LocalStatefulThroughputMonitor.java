package com.gpstracker.server.core.monitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.gpstracker.server.api.core.ThroughputMonitor;
import com.gpstracker.server.model.internal.ProcessingContext;

/**
 * A local stateful throughput monitor provides a localised representation of the throughput of a single instance, with the
 * information based on the the duration of the application is running. If the application is restarted then the current
 * state is lost, and the statistics will be based on the duration of the applications life.
 *
 * A local stateful monitor will provide fast processing as their is no I/O and data is stored in memory. It is only applicable
 * if all servers are running on a similar infrastructure/resource with a similar distribution of load. 
 */
public class LocalStatefulThroughputMonitor implements ThroughputMonitor {

    /** The logger to use for logging the metrics of input requests. */
    private static final Logger REQUEST_INPUT_LOG = Logger.getLogger("Metrics.Input");
    /** The logger to use for logging the metrics of task completion. */
    private static final Logger COMPLETED_LOG = Logger.getLogger("Metrics.Completed");    
    /**
     *  Executor service for processing requests on an isolated thread. This is
     *  to allow separate worker threads to manage the statistics instead of forcing the
     *  calling thread to be side-tracked processing the statistic updates.
     */
    private ExecutorService requestWorker = Executors.newFixedThreadPool(50);
    /** Counts the operations received. */    
    private static final AtomicLong operationsRecieved = new AtomicLong(0);
    /** Counts the operations completed. */    
    private static final AtomicLong operationsCompleted = new AtomicLong(0); 
    /** Counts the in progress request operations. */    
    private static final AtomicLong inProgressOperations = new AtomicLong(0);
    /** The mean time of processing. */
    private static final AtomicLong totalProcessingTimeInMilliSeconds = new AtomicLong();
    /** The current expected processing time - does not need to be thread safe. */
    private static long expectedProcessingTime;
           
    /**
     * Default constructor.
     */
    public LocalStatefulThroughputMonitor() {
    }
    
    /**
     * Gets the number of processing operations that are currently outstanding.
     *
     * @return the number of outstanding operations
     */
    @Override
    public long getOutstandingMessageRequestCount() {
        return inProgressOperations.longValue();
    }

    /**
     * Gets the frequency of operations processed by the application per second.
     * 
     * @return the frequency of operations processed per second.
     */
    @Override
    public long getOperationRequestFrequencyPerSecond() {
        // Not supported in this implementation.
        // It is not required by the project
        throw new UnsupportedOperationException();
    }

    @Override
    public long getOperationProcessedFrequencyPerSecond() {
        // Not supported in this implementation
        // It is not required by the project
        throw new UnsupportedOperationException();
    }
    
    /**
     * Gets the average processing time of the application.
     * 
     * @return the average processing time
     */
    @Override
    public long getAverageProcessingTime() {
        if (totalProcessingTimeInMilliSeconds.longValue() == 0 || operationsCompleted.longValue() == 0) {
            return 0;
        }
        return totalProcessingTimeInMilliSeconds.longValue() / operationsCompleted.longValue();
    }

    /**
     * Gets the current processing time expected.
     * 
     * @return the current processing time
     */
    @Override
    public long getCurrentExpectedProcessingTime() {
        return expectedProcessingTime;
    }

    /**
     * Notifies the monitor that a request has been received.
     * 
     * @param processingContext the processing context
     */
    @Override
    public void notifyRequestReceived(final ProcessingContext processingContext) {
        if (REQUEST_INPUT_LOG.isDebugEnabled()) {
            REQUEST_INPUT_LOG.debug("Recieved Request - Processing ID: " + processingContext.getProcessingId());
        }
        
        inProgressOperations.incrementAndGet();
        operationsRecieved.incrementAndGet();        
    }

    /**
     * Notifies the monitor that a request has been completed.
     * 
     * @param processingContext the processing context
     */
    @Override
    public void notifyRequestCompleted(final ProcessingContext processingContext) {
        long durationInMilliSeconds = processingContext.calculateProcessingTime();
        if (COMPLETED_LOG.isDebugEnabled()) {
            COMPLETED_LOG.debug(
                    "Completed Processing - Processing ID: " + processingContext.getProcessingId()
                    + ". Start time: " + processingContext.getProcessingStartTime() 
                    + ". Finish time: " + processingContext.getProcessingCompleteTime() 
                    + ". Time Taken: " + durationInMilliSeconds
                    + ". Status: " + processingContext.isProcessingCompletedSuccessfully());
        }
        
        expectedProcessingTime = durationInMilliSeconds;
        operationsCompleted.incrementAndGet();
        inProgressOperations.decrementAndGet();
        totalProcessingTimeInMilliSeconds.addAndGet(durationInMilliSeconds);
    }
}
