package com.gpstracker.server.api.service.gps;

import java.util.List;

import org.joda.time.LocalDate;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

/**
 * 
 */
public interface GpsService {
    
    boolean store(UserGlobalPosition globalPosition);
    
    boolean delete(UserGlobalPosition globalPosition);
    
    boolean update(UserGlobalPosition globalPosition);
    
    List<GlobalPosition> loadByUserName(String userName);
    
    List<GlobalPosition> loadByUserId(long userId);
    
    List<GlobalPosition> loadByUserIdAndDateRange(long userId, LocalDate startDate, LocalDate endDate);

}
