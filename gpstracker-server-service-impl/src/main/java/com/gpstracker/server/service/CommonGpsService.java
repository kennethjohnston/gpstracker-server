package com.gpstracker.server.service;

import java.util.List;

import org.joda.time.LocalDate;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.service.gps.api.GpsService;
import com.gpstracker.server.service.persister.dao.api.GPSCoordinatesDAO;

public class CommonGpsService implements GpsService {
    
    private GPSCoordinatesDAO persister;

    @Override
    public boolean store(GlobalPosition gpsCoordinates) {
        return persister.store(gpsCoordinates);
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
    public List<GlobalPosition> loadByUserIdAndDateRange(long userId,
            LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        return null;
    }

    //---------------------------------------------------------------------------------------------
    // Getters and Setters.
    /**
     * @return the persister
     */
    public GPSCoordinatesDAO getPersister() {
        return persister;
    }

    /**
     * @param persister the persister to set
     */
    public void setPersister(GPSCoordinatesDAO persister) {
        this.persister = persister;
    }

    @Override
    public boolean delete(GlobalPosition gpsCoordinates) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(GlobalPosition gpsCoordinates) {
        // TODO Auto-generated method stub
        return false;
    }
}
