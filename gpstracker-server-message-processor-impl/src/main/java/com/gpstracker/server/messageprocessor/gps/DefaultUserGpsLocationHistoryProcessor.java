package com.gpstracker.server.messageprocessor.gps;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import com.gpstracker.server.api.messageprocessor.gps.UserGpsLocationHistoryProcessor;
import com.gpstracker.server.api.service.gps.GpsService;
import com.gpstracker.server.messageprocessor.AbstractMessageProcessor;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.gps.GlobalPositionList;
import com.gpstracker.server.model.internal.request.HistoricGlobalPositionRequirements;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

/**
 * The default implementation of how GPS location registrations should be processed. The implementation
 * will store the global position to the database, and will carry out any business logic that has been
 * specific by the business processors.
 */
public class DefaultUserGpsLocationHistoryProcessor extends AbstractMessageProcessor<HistoricGlobalPositionRequirements, UserHistoricGlobalPositionProcessingResult> implements UserGpsLocationHistoryProcessor {

    /** The logger to use for this class. */
    private static final Logger LOGGER = Logger.getLogger(DefaultUserGpsLocationHistoryProcessor.class);
    /** The GPS service. */
    private GpsService gpsService;

    @Override
    protected UserHistoricGlobalPositionProcessingResult createInitialResult(final HistoricGlobalPositionRequirements locationRequestRequirements) {
        List<GlobalPosition> globalPositionList = null;
        if (locationRequestRequirements.getStartDateTime() == null
                || locationRequestRequirements.getEndDateTime() == null) {
            globalPositionList = gpsService.loadAllByUserId(locationRequestRequirements.getUserId());
        } else {
            globalPositionList = gpsService.loadAllByUserIdAndDateRange(
                    locationRequestRequirements.getUserId(),
                    locationRequestRequirements.getStartDateTime(),
                    locationRequestRequirements.getEndDateTime());
        }

        UserHistoricGlobalPositionProcessingResult result = new UserHistoricGlobalPositionProcessingResult();
        if (CollectionUtils.isEmpty(globalPositionList)) {
          result.addWarning("No results found");
          globalPositionList = new ArrayList<GlobalPosition>();
        } else {
            result.setHistoricGlobalPositionList(new GlobalPositionList(globalPositionList));
        }

        return result;
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * Gets the GPS service.
     * 
     * @return the gpsService
     */
    public GpsService getGpsService() {
        return gpsService;
    }

    /**
     * Sets the GPS service.
     * 
     * @param gpsService the gpsService to set
     */
    public void setGpsService(final GpsService gpsService) {
        this.gpsService = gpsService;
    }
}
