package com.gpstracker.server.service.persister.dao;

import java.sql.Date;

import com.gpstracker.server.api.service.persister.dao.UserDAO;
import com.gpstracker.server.model.internal.user.User;
import com.gpstracker.server.service.persister.mapper.UserMapper;

/**
 * An implementation of the User data access object. The implementation
 */
public class UserJDBCDAO extends AbstractJDBCDAO implements UserDAO {

    /** . */
    private static final String INSERT_SQL = "insert into GPS_TRACKER.USER (user_id, user_name, user_telephone, user_email, user_registration_date) values (?, ?, ?, ?, ?)";
    /** . */
    private static final String BASE_LOAD_SQL = "select user_id, user_name, user_telephone, user_email, user_registration_date from GPS_TRACKER.USER";
    /** . */
    private static final String LOAD_BY_ID_SQL = BASE_LOAD_SQL + " where USER_ID = ?";
    /** . */
    private static final String LOAD_BY_USERNAME_SQL = BASE_LOAD_SQL + " where USER_NAME = ?";
    /** . */
    private static final String UPDATE_SQL = "update GPS_TRACKER.USER set ";
    /** . */
    private static final String BASE_DELETE_SQL = "delete from GPS_TRACKER.USER";
    /** . */
    private static final String DELETE_BY_ID_SQL = BASE_DELETE_SQL + " where user_id = ?";
    /** . */
    private static final String DELETE_BY_USERNAME_SQL = BASE_DELETE_SQL + " where user_name = ?";

    /**
     *  
     */
    @Override
    public boolean store(final User object) {
        boolean storeSuccessful = false;
                
        getJdbcTemplate().update(
                INSERT_SQL,
                object.getUserId(),
                object.getUserName(),
                object.getUserPhoneNumber(),
                object.getUserEmailAddress(),
                Date.valueOf(object.getUserRegistrationDate().toString()));
     
        return storeSuccessful;
    }

    @Override
    public User load(final long id) {
        User user = getJdbcTemplate().queryForObject(
                LOAD_BY_ID_SQL,
                new Object[] {id},
                new UserMapper());
        
        return user;
    }
    
    @Override
    public User loadByUserName(final String userName) {
        User user = getJdbcTemplate().queryForObject(
                LOAD_BY_ID_SQL,
                new Object[] {userName},
                new UserMapper());
        
        return user;
    }
    
    @Override
    public User loadByEmailAddress(final String emailAddress) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User loadByPhoneNumber(final String phoneNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(final User object) {
        getJdbcTemplate().update(
                UPDATE_SQL,
                object.getUserId(),
                object.getUserName(),
                object.getUserPhoneNumber(),
                object.getUserEmailAddress(),
                Date.valueOf(object.getUserRegistrationDate().toString()));
        
        return true;
    }

    @Override
    public boolean delete(final User object) {
        getJdbcTemplate().update(
                DELETE_BY_ID_SQL,
                object.getUserId());
         
        return true;
    }
}
