package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.sever.model.internal.user.User;

public class UserMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		 user.setUserId(rs.getInt("user_id"));
		 user.setUserName(rs.getString("user_name"));
		 user.setUserPhoneNumber(rs.getString("user_telephone"));
		 user.setUserEmailAddress(rs.getString("user_email"));
		 user.setUserRegistrationDate(/** new LocalDate(rs.getDate("user_registration_date"))*/ null);
		return user;
	}
}
