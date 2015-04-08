package com.gpstracker.server.service.persister.dao;

import com.gpstracker.server.api.service.persister.dao.UserGlobalPositionDAO;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;
import com.gpstracker.server.service.persister.mapper.GlobalPositionMapper;
import com.gpstracker.server.service.persister.mapper.UserGlobalPositionMapper;

public class UserGlobalPositionJDBCDAO extends AbstractJDBCDAO implements UserGlobalPositionDAO {

    /** The SQL statement to insert a record.*/
    private static final String INSERT_SQL = "insert into gps_tracker.gps_coordinates (gps_user_id, gps_latitude, gps_longitude, gps_date_time) values (?, ? ,?, ?)";
    /** The base SQL statement that will load all columns from the row . */
    private static final String BASE_LOAD_SQL = "select gps_user_id, gps_latitude, gps_longitude, gps_date_time from gps_tracker.gps_coordinates";
    /** The SQL statement to load a row/recod by the user Id. */
    private static final String LOAD_BY_ID_SQL = BASE_LOAD_SQL + " where gps_user_id = ?";
    /** The SQL statment to update an existing row. */
    private static final String UPDATE_SQL = "update gps_tracker.gps_coordinates set ";
    /** The base SQL statement to delete a row/record. */
    private static final String BASE_DELETE_SQL = "delete from gps_tracker.gps_coordinates";
    /** The SQL statement to delete a row by the user Id. */
    private static final String DELETE_BY_ID_SQL = BASE_DELETE_SQL + " where gps_user_id = ?";
    
    /**
     * Stors the user global p
     */
    @Override
    public boolean store(final UserGlobalPosition object) {
        boolean storeSuccessful = false;        
        getJdbcTemplate().update(
                INSERT_SQL,
                object.getUserId(),
                object.getGlobalPosition().getLatitude(),
                object.getGlobalPosition().getLongitude(),
                object.getGlobalPosition().getDateTime());
     
        return storeSuccessful;
    }

    @Override
    public UserGlobalPosition load(final long id) {
        UserGlobalPosition userGlobalPosition = getJdbcTemplate().queryForObject(
                LOAD_BY_ID_SQL,
                new Object[] {id},
                new UserGlobalPositionMapper());
        
        return userGlobalPosition;
    }
    
    @Override
    public GlobalPosition loadGlobalPositionByUserId(final long id) {
        GlobalPosition globalPosition = getJdbcTemplate().queryForObject(
                LOAD_BY_ID_SQL,
                new Object[] {id},
                new GlobalPositionMapper());
        
        return globalPosition;
    }

    @Override
    public boolean update(final UserGlobalPosition object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(final UserGlobalPosition object) {
        getJdbcTemplate().update(
                DELETE_BY_ID_SQL,
                object.getUserId());
        
        return false;
    }
}
