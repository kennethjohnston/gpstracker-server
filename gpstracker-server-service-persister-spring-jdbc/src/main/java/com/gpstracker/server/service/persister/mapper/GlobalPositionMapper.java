package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import org.joda.time.DateTime;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.model.internal.gps.GlobalPosition;

public class GlobalPositionMapper implements RowMapper<GlobalPosition > {
    
    private DateFormatter formatter = new DateFormatter("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public GlobalPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        GlobalPosition globalPosition = new GlobalPosition();
        globalPosition.setLatitude(rs.getDouble("gps_latitude"));
        globalPosition.setLongitude(rs.getDouble("gps_longitude"));
        globalPosition.setDateTime(DateTime.parse(formatter.print(rs.getTimestamp("gps_date_time"), Locale.ENGLISH)));

        return globalPosition;
    }
}
