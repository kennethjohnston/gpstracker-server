package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.model.internal.gps.GlobalPosition;

public class GpsCoordinatesMapper implements RowMapper<GlobalPosition > {

    public GlobalPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        GlobalPosition gpsCoordinates = new GlobalPosition();
        gpsCoordinates.setLatitude(rs.getDouble("user_id"));
        gpsCoordinates.setLongitude(rs.getDouble("user_telephone"));

        return gpsCoordinates;
    }

}
