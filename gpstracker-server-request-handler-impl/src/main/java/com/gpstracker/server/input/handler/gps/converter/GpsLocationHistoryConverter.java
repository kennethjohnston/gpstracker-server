package com.gpstracker.server.input.handler.gps.converter;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.internal.request.HistoricGlobalPositionRequirements;

public class GpsLocationHistoryConverter implements ExternalInputConverter<UserGpsLocationHistoryRequest, HistoricGlobalPositionRequirements> {

    @Override
    public HistoricGlobalPositionRequirements convert(final UserGpsLocationHistoryRequest externalInput) {
        HistoricGlobalPositionRequirements userHistoricGlobalPositionRequirements = new HistoricGlobalPositionRequirements();
        userHistoricGlobalPositionRequirements.setUserId(externalInput.getUserIdentifier().getUserId());
        if (StringUtils.isNotBlank(externalInput.getStartTime())) {
            userHistoricGlobalPositionRequirements.setStartDateTime(DateTime.parse(externalInput.getStartDate() + "T" + externalInput.getStartTime()));
        } else {
            userHistoricGlobalPositionRequirements.setStartDateTime(DateTime.parse(externalInput.getStartDate() + "T00:00"));
        }
        
        if (StringUtils.isNotBlank(externalInput.getEndTime())) {
            userHistoricGlobalPositionRequirements.setEndDateTime(DateTime.parse(externalInput.getEndDate() + "T" + externalInput.getEndTime())); 
        } else {
            userHistoricGlobalPositionRequirements.setEndDateTime(DateTime.parse(externalInput.getEndDate() + "T23:59"));
        }
        
        return userHistoricGlobalPositionRequirements;
    }

}
