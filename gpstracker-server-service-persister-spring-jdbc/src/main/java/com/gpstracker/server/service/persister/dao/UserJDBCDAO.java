package com.gpstracker.server.service.persister.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.gpstracker.server.api.service.persister.dao.UserDAO;
import com.gpstracker.server.model.internal.user.User;
import com.gpstracker.server.service.persister.mapper.UserMapper;

/**
 * An implementation of the User data access object. The implementation
 */
public class UserJDBCDAO extends AbstractJDBCDAO implements UserDAO {

    /** Logger. */
    private static final Logger LOGGER = Logger.getLogger("Database");
    /** The SQL statement to insert record. */
    private static final String INSERT_SQL = "insert into gps_tracker.user (user_id, user_name, user_password, user_telephone, user_email, user_registration_date) values (?, ?, ?, ?, ?, ?)";
    /** The base SQL statement to load record. */
    private static final String BASE_LOAD_SQL = "select user_id, user_name, user_password, user_telephone, user_email, user_registration_date from gps_tracker.user";
    /** The SQL statement to load record by user ID. */
    private static final String LOAD_BY_ID_SQL = BASE_LOAD_SQL + " where user_id = ?";
    /** The SQL statement to load record by user name. */
    private static final String LOAD_BY_USERNAME_SQL = BASE_LOAD_SQL + " where user_name = ?";
    /** The SQL statement to update record. */
    private static final String UPDATE_SQL = "update gps_tracker.user set ";
    /** The base SQL statement to delete record. */
    private static final String BASE_DELETE_SQL = "delete from gps_tracker.user";
    /** The SQL statement to deleted record by user ID. */
    private static final String DELETE_BY_ID_SQL = BASE_DELETE_SQL + " where user_id = ?";

    /**
     *  Stores user record.
     *  
     */
    @Override
    public boolean store(final User user) {
        boolean storeSuccessful = true;        
        try {
            getJdbcTemplate().update(
                INSERT_SQL,
                user.getUserId(),
                user.getUserName(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getEmailAddress(),
                user.getRegistrationDate());
        } catch (DataAccessException dEx) {
            storeSuccessful = false;
            LOGGER.error("Could not write record to database: " + dEx);
        }
     
        return storeSuccessful;
    }

    @Override
    public User loadByUserId(final String id) {
        User user = null;
        try {
            user = getJdbcTemplate().queryForObject(
                    LOAD_BY_ID_SQL,
                    new Object[] { id },
                    new UserMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }

        return user;
    }
    
    @Override
    public User loadByUserName(final String userName) {
        User user = null;
        try {
            user = getJdbcTemplate().queryForObject(
                LOAD_BY_USERNAME_SQL,
                new Object[] {userName},
                new UserMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }

        return user;
    }
    
    @Override
    public User loadByEmailAddress(final String emailAddress) {
        User user = null;
        try {
            user = getJdbcTemplate().queryForObject(
                    LOAD_BY_USERNAME_SQL,
                    new Object[] {emailAddress},
                    new UserMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not load record to database: " + dEx);
        }

        return user;
    }

    @Override
    public User loadByPhoneNumber(final String phoneNumber) {
        User user = null;
        try {
            user = getJdbcTemplate().queryForObject(
                    LOAD_BY_USERNAME_SQL,
                    new Object[] {phoneNumber},
                    new UserMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            LOGGER.error("Could not write record to database: " + dEx);
        }

        return user;
    }

    @Override
    public boolean update(final User object) {
        boolean updatedSuccessful = true;        
        try {
            getJdbcTemplate().update(
                UPDATE_SQL,
                object.getUserId(),
                object.getUserName(),
                object.getPhoneNumber(),
                object.getEmailAddress(),
                object.getRegistrationDate());
        } catch (DataAccessException dEx) {
            updatedSuccessful = false;
            LOGGER.error("Could not update record to database: " + dEx);
        }
        
        return updatedSuccessful;
    }

    @Override
    public boolean delete(final User object) {
        boolean deletedSuccessfully = true;        
        try {            
            getJdbcTemplate().update(
                DELETE_BY_ID_SQL,
                object.getUserId());
        } catch (DataAccessException dEx) {
            deletedSuccessfully = false;
            LOGGER.error("Could not write record to database: " + dEx);
        }
        
        return deletedSuccessfully;
    }
    
    
    @Override
    public User load(long id) {
        // Not currently support
        return null;
    }
}
