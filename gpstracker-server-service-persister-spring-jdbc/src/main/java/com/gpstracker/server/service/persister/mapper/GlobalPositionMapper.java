package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.model.internal.gps.GlobalPosition;

public class GlobalPositionMapper implements RowMapper<GlobalPosition > {

    public GlobalPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        GlobalPosition globalPosition = new GlobalPosition();
        globalPosition.setLatitude(rs.getDouble("gps_latitude"));
        globalPosition.setLongitude(rs.getDouble("gps_longitude"));
        
        return globalPosition;
    }
}
