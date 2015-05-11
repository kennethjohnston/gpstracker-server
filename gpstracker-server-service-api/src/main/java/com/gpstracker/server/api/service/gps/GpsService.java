package com.gpstracker.server.api.service.gps;

import java.util.List;

import org.joda.time.DateTime;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

/**
 * 
 */
public interface GpsService {
    
    boolean store(UserGlobalPosition globalPosition);
    
    boolean delete(UserGlobalPosition globalPosition);
    
    boolean update(UserGlobalPosition globalPosition);
    
    List<GlobalPosition> loadAllByUserName(String userName);
    
    List<GlobalPosition> loadAllByUserId(String userId);
    
    List<GlobalPosition> loadAllByUserIdAndDateRange(String userId, DateTime startDate, DateTime endDate);
}
