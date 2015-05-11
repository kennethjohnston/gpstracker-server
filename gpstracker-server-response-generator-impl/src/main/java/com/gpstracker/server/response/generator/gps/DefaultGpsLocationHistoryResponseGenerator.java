package com.gpstracker.server.response.generator.gps;

import java.util.ArrayList;
import java.util.List;

import com.gpstracker.server.api.response.generator.gps.GpsLocationHistoryResponseGenerator;
import com.gpstracker.server.model.external.gps.GpsLocation;
import com.gpstracker.server.model.external.gps.HistoricGpsLocation;
import com.gpstracker.server.model.external.response.UserGpsLocationHistoryResponse;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.result.UserHistoricGlobalPositionProcessingResult;

public class DefaultGpsLocationHistoryResponseGenerator implements GpsLocationHistoryResponseGenerator {

    @Override
    public UserGpsLocationHistoryResponse generateResponse(final UserHistoricGlobalPositionProcessingResult processingResult ) {
        UserGpsLocationHistoryResponse response = new UserGpsLocationHistoryResponse();
        
        List<HistoricGpsLocation> historicGpsLocationList = new ArrayList<HistoricGpsLocation>();
        if (processingResult.getHistoricGlobalPositionList() != null) {
            for (GlobalPosition globalPosition : processingResult.getHistoricGlobalPositionList().getGlobalPositionList()) {
                HistoricGpsLocation historicLocation = new HistoricGpsLocation();
                GpsLocation gpsLocation = new GpsLocation();
                gpsLocation.setLatitude(String.valueOf(globalPosition.getLatitude()));
                gpsLocation.setLongitude(String.valueOf(globalPosition.getLongitude()));
                historicLocation.setGpsLocation(gpsLocation);
                if (globalPosition.getDateTime() != null) {
                    historicLocation.setDate(globalPosition.getDateTime().toString());
                    historicLocation.setTime(globalPosition.getDateTime().toString()); 
                }
                historicGpsLocationList.add(historicLocation);
            }
        } else {
            response.addWarning("No results");
        }
        
        response.setHistoricGpsLocationList(historicGpsLocationList);
        response.setSuccessful(true);

        return response;
    }
}
