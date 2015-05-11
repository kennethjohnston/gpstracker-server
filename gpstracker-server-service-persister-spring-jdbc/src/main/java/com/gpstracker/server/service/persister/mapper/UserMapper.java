package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.model.internal.user.User;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {        
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setUserName(rs.getString("user_name"));
        user.setPassword(rs.getString("user_password"));
        user.setPhoneNumber(rs.getString("user_telephone"));
        user.setEmailAddress(rs.getString("user_email"));        

        return user;
    }
}
