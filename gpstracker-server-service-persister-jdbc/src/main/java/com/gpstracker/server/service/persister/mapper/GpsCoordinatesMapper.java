package com.gpstracker.server.service.persister.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;

public class GpsCoordinatesMapper implements RowMapper<GPSCoordinates > {

	public GPSCoordinates mapRow(ResultSet rs, int rowNum) throws SQLException {
		GPSCoordinates gpsCoordinates = new GPSCoordinates();
		gpsCoordinates.setLatitude(rs.getDouble("user_id"));
		gpsCoordinates.setLongitude(rs.getDouble("user_telephone"));

		return gpsCoordinates;
	}

}
