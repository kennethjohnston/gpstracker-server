package com.gpstracker.server.service.persister.dao;

import java.sql.Date;

import com.gpstracker.server.service.persister.dao.api.UserDAO;
import com.gpstracker.server.service.persister.mapper.UserMapper;
import com.gpstracker.sever.model.internal.user.User;

/**
 * An implementation of the User data access object. The implementation
 * @author kenneth
 *
 */
public class UserJDBCDAO extends AbstractJDBCDAO implements UserDAO {

	private static String inserSQL = "insert into GPS_TRACKER.USER (user_id, user_name, user_telephone, user_email, user_registration_date)"
			+ " values (?, ?, ?, ?, ?)";
	private static String loadSQL = "select user_id, user_name, user_telephone, user_email, user_registration_date"
			+ " from GPS_TRACKER.USER where USER_ID = ?";
	private static String updateSQL = "";
	private static String deleteSQL = "delete * from GPS_TRACKER.USER where user_id = ?";
	
	@Override
	public boolean store(final User object) {
		boolean storeSuccessful = false;
				
		getJdbcTemplate().update(
				inserSQL,
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
				loadSQL,
				new Object[] {id},
				new UserMapper());
		
		return user;
	}

	@Override
	public boolean update(final User object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final User object) {
		// TODO Auto-generated method stub
		return false;
	}
}
