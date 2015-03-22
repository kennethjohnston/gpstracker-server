package com.gpstracker.server.service.persister.dao;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.service.persister.dao.api.GPSCoordinatesDAO;

public class GpsCoordinatesJDBCDAO extends AbstractJDBCDAO implements GPSCoordinatesDAO {

    private static String inserSQL = "INSERT INTO gps_tracker.gps_coordinates (gps_user_id, gps_latitude, gps_longitude) VALUES (?, ? ,?)";
    private static String loadSQL = "";
    private static String updateSQL = "";
    private static String deleteSQL = "";
    
    @Override
    public boolean store(final GlobalPosition object) {
        boolean storeSuccessful = false;
        
        getJdbcTemplate().update(
                inserSQL,
                "1",
                object.getLatitude(),
                object.getLongitude());
     
        return storeSuccessful;
    }

    @Override
    public GlobalPosition load(final long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(final GlobalPosition object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(final GlobalPosition object) {
        // TODO Auto-generated method stub
        return false;
    }

}
