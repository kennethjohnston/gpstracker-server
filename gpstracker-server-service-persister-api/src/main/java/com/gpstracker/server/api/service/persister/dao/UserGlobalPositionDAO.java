package com.gpstracker.server.api.service.persister.dao;

import java.util.List;

import org.joda.time.DateTime;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

/**
 * Defines the additional persistence functionality required by the user global position DAO.
 */
public interface UserGlobalPositionDAO extends GenericDAO<UserGlobalPosition> {
       
    List<GlobalPosition> loadAllByUserName(String userName);
    
    List<GlobalPosition> loadAllByUserId(String userId);

    List<GlobalPosition> loadAllByUserIdAndDateRange(String userId, DateTime startDate, DateTime endDate);   
}
