package com.gpstracker.server.messageprocessor.businessrules;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.gpstracker.server.api.messageprocessor.businessrules.BusinessRulesProcessor;
import com.gpstracker.server.model.internal.result.AbstractProcessingResult;

public class WorkLoadEmulatingBusinessRulesProcessor implements BusinessRulesProcessor<AbstractProcessingResult, AbstractProcessingResult> {

    private Logger LOGGER = Logger.getLogger("Emulator");
    private int cycles = 50000;

    @Override
    public AbstractProcessingResult processBusinessRules(final AbstractProcessingResult result) {
        long start = Calendar.getInstance().getTimeInMillis();        

        Collection<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < cycles; i++) {
            Integer obect = new Integer(i);
            intList.add(obect);
            intList.toArray();
        }

        long end = Calendar.getInstance().getTimeInMillis();
        LOGGER.debug("Workload Emulation Took: " + (end - start) + " milli-seconds");

        return result;
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters
    /**
     * @return the cycles
     */
    public int getCycles() {
        return cycles;
    }

    /**
     * @param cycles the cycles to set
     */
    public void setCycles(int cycles) {
        this.cycles = cycles;
    }
}
