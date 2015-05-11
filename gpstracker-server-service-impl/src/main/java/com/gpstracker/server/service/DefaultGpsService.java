package com.gpstracker.server.service;

import java.util.List;

import org.joda.time.DateTime;

import com.gpstracker.server.api.service.gps.GpsService;
import com.gpstracker.server.api.service.persister.dao.UserGlobalPositionDAO;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public class DefaultGpsService implements GpsService {
    
    /** The persister for GPS data queries. */
    private UserGlobalPositionDAO persister;

    //---------------------------------------------------------------------------------------------
    @Override
    public boolean store(final UserGlobalPosition globalPosition) {
        return persister.store(globalPosition);
    }
    
    @Override
    public boolean delete(final UserGlobalPosition globalPosition) {
        return persister.delete(globalPosition);
    }

    @Override
    public boolean update(final UserGlobalPosition globalPosition) {
        return persister.update(globalPosition);
    }
    
    @Override
    public List<GlobalPosition> loadAllByUserName(String userName) {
        return persister.loadAllByUserName(userName);
    }

    @Override
    public List<GlobalPosition> loadAllByUserId(String userId) {
        return persister.loadAllByUserId(userId);
    }

    @Override
    public List<GlobalPosition> loadAllByUserIdAndDateRange(
            final String userId,
            final DateTime startDate,            
            final DateTime endDate) {
        return persister.loadAllByUserIdAndDateRange(userId, startDate, endDate);
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * @return the persister
     */
    public UserGlobalPositionDAO getPersister() {
        return persister;
    }

    /**
     * @param persister the persister to set
     */
    public void setPersister(final UserGlobalPositionDAO persister) {
        this.persister = persister;
    }
}
