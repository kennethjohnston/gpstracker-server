package com.gpstracker.server.input.handler.gps.converter;

import org.joda.time.DateTime;

import com.gpstracker.server.api.input.handler.ExternalInputConverter;
import com.gpstracker.server.model.external.request.UserGpsLocationHistoryRequest;
import com.gpstracker.server.model.internal.request.UserHistoricGlobalPositionRequirements;

public class GpsLocationHistoryConverter implements ExternalInputConverter<UserGpsLocationHistoryRequest, UserHistoricGlobalPositionRequirements> {

    @Override
    public UserHistoricGlobalPositionRequirements convert(final UserGpsLocationHistoryRequest externalInput) {
        UserHistoricGlobalPositionRequirements userHistoricGlobalPositionRequirements = new UserHistoricGlobalPositionRequirements();
        userHistoricGlobalPositionRequirements.setStartDateTime(DateTime.parse(externalInput.getStartDate() + "T" + externalInput.getStartTime()));
        userHistoricGlobalPositionRequirements.setEndDateTime(DateTime.parse(externalInput.getEndDate() + "T" + externalInput.getEndTime()));
        
        return userHistoricGlobalPositionRequirements;
    }

}
