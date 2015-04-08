package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public class UserGlobalPositionMapper implements RowMapper<UserGlobalPosition > {

    public UserGlobalPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        GlobalPosition globalPosition = new GlobalPosition();
        globalPosition.setLatitude(rs.getDouble("gps_latitude"));
        globalPosition.setLongitude(rs.getDouble("gps_longitude"));
        globalPosition.setDateTime(DateTime.parse(rs.getTimestamp("gps_date_time").toString()));
        
        return new UserGlobalPosition(
                rs.getLong("gps_user_id"),
                globalPosition);
    }
}
