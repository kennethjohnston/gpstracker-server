package com.gpstracker.server.service.gps.api;

import java.util.List;

import org.joda.time.LocalDate;

import com.gpstracker.server.model.internal.gps.GlobalPosition;

/**
 * 
 */
public interface GpsService {
    
    boolean store(GlobalPosition gpsCoordinates);
    
    boolean delete(GlobalPosition gpsCoordinates);
    
    boolean update(GlobalPosition gpsCoordinates);
    
    List<GlobalPosition> loadByUserName(String userName);
    
    List<GlobalPosition> loadByUserId(long userId);
    
    List<GlobalPosition> loadByUserIdAndDateRange(long userId, LocalDate startDate, LocalDate endDate);

}
