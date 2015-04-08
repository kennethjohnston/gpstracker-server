package com.gpstracker.server.service;

import java.util.List;

import org.joda.time.LocalDate;

import com.gpstracker.server.api.service.gps.GpsService;
import com.gpstracker.server.api.service.persister.dao.UserGlobalPositionDAO;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public class DefaultGpsService implements GpsService {
    
    private UserGlobalPositionDAO persister;

    @Override
    public boolean store(final UserGlobalPosition globalPosition) {
        return persister.store(globalPosition);
    }
    
    @Override
    public List<GlobalPosition> loadByUserName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GlobalPosition> loadByUserId(long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GlobalPosition> loadByUserIdAndDateRange(
            long userId,
            LocalDate startDate,
            LocalDate endDate) {
        // TODO Auto-generated method stub
        return null;
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

    @Override
    public boolean delete(final UserGlobalPosition globalPosition) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(final UserGlobalPosition globalPosition) {
        // TODO Auto-generated method stub
        return false;
    }
}
