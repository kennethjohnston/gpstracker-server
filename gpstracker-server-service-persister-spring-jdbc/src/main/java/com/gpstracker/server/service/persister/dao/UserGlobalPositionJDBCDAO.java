package com.gpstracker.server.service.persister.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.gpstracker.server.api.service.persister.dao.UserGlobalPositionDAO;
import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;
import com.gpstracker.server.service.persister.mapper.GlobalPositionMapper;
import com.gpstracker.server.service.persister.mapper.UserGlobalPositionMapper;

public class UserGlobalPositionJDBCDAO extends AbstractJDBCDAO implements UserGlobalPositionDAO {

    /** The Logger. */
    private static final Logger LOGGER = Logger.getLogger("Database");
    /** The SQL statement to insert a record.*/
    private static final String INSERT_SQL = "insert into gps_tracker.gps_coordinates (gps_user_id, gps_latitude, gps_longitude, gps_date_time) values (?, ? ,?, ?)";
    /** The base SQL statement that will load all columns from the row . */
    private static final String BASE_LOAD_SQL = "select gps_user_id, gps_latitude, gps_longitude, gps_date_time from gps_tracker.gps_coordinates";
    /** The SQL statement to load a row/recod by the user Id. */
    private static final String LOAD_BY_ID_SQL = BASE_LOAD_SQL + " where gps_id = ?";
    /** The SQL statement to load a row/recod by the user Id. */
    private static final String LOAD_BY_USER_ID_SQL = BASE_LOAD_SQL + " where gps_user_id = ?";
    /** The SQL statement to load a row/recod by the user Id. */
    private static final String LOAD_BY_USER_NAME_SQL = BASE_LOAD_SQL + " where gps_user_id = ?";
    /** The SQL statement to load a row/recod by the user Id. */
    private static final String LOAD_BY_USER_ID_AND_DATE_RANGE_SQL = BASE_LOAD_SQL + " where gps_user_id = ? and gps_date_time >= ? and gps_date_time <= ?";
    /** The SQL statement to update an existing row. */
    private static final String UPDATE_SQL = "update gps_tracker.gps_coordinates set ";
    /** The base SQL statement to delete a row/record. */
    private static final String BASE_DELETE_SQL = "delete from gps_tracker.gps_coordinates";
    /** The SQL statement to delete a row by the user Id. */
    private static final String DELETE_BY_ID_SQL = BASE_DELETE_SQL + " where gps_user_id = ?";
    
    /**
     * Stores the user global positions.
     */
    @Override
    public boolean store(final UserGlobalPosition object) {
        boolean storeSuccessful = true;        
        try {
            getJdbcTemplate().update(
                INSERT_SQL,
                object.getUserId(),
                object.getGlobalPosition().getLatitude(),
                object.getGlobalPosition().getLongitude(),
                object.getGlobalPosition().getDateTime());
        } catch (DataAccessException dEx) {
            storeSuccessful = false;
            LOGGER.error("Could not write record to database: " + dEx);
        }
        return storeSuccessful;
    }

    @Override
    public UserGlobalPosition load(final long id) {
        UserGlobalPosition userGlobalPosition = null;
        try {
            userGlobalPosition = getJdbcTemplate().queryForObject(
                LOAD_BY_ID_SQL,
                new Object[] {id},
                new UserGlobalPositionMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }
        
        return userGlobalPosition;
    }
    
    @Override
    public List<GlobalPosition> loadAllByUserName(String userName) {
        List<GlobalPosition> globalPositions = null;
        try {
            globalPositions = getJdbcTemplate().query(
                LOAD_BY_USER_NAME_SQL,
                new Object[] {userName},
                new GlobalPositionMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }
        return globalPositions;
    }

    @Override
    public List<GlobalPosition> loadAllByUserId(final String userId) {
        List<GlobalPosition> globalPositions = null;
        try {
            globalPositions = getJdbcTemplate().query(
                LOAD_BY_USER_ID_SQL,
                new Object[] {userId},
                new GlobalPositionMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }
        
        return globalPositions;
    }

    @Override
    public List<GlobalPosition> loadAllByUserIdAndDateRange(
            final String userId,
            final DateTime startDate,            
            final DateTime endDate) {
        List<GlobalPosition> globalPositions = null;
        try {
            globalPositions = getJdbcTemplate().query(
                LOAD_BY_USER_ID_AND_DATE_RANGE_SQL,
                new Object[] {userId, toTimeStampString(startDate), toTimeStampString(endDate)},
                new GlobalPositionMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }
        
        return globalPositions;
    }

    @Override
    public boolean update(final UserGlobalPosition object) {
        boolean updatedSuccessful = true;        
        try {
            getJdbcTemplate().update(
                    UPDATE_SQL);                
        } catch (DataAccessException dEx) {
            updatedSuccessful = false;
            LOGGER.error("Could not write record to database: " + dEx);
        }
 
        return updatedSuccessful;
    }

    @Override
    public boolean delete(final UserGlobalPosition object) {
        boolean deleteSuccessful = true;        
        try {
            getJdbcTemplate().update(
                DELETE_BY_ID_SQL,
                object.getUserId());
        } catch (DataAccessException dEx) {
            deleteSuccessful = false;
            LOGGER.error("Could not delete record from database: " + dEx);
        }
        
        return deleteSuccessful;
    }
    
    //---------------------------------------------------------------------------------------------
    private String toTimeStampString(final DateTime dateTime) {
        return dateTime.toString("YYYY-MM-dd' 'HH:mm:ss");        
    }
}
