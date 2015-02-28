package com.gpstracker.server.service.persister.dao;

import java.sql.Date;

import com.gpstracker.server.model.internal.input.gps.GPSCoordinates;
import com.gpstracker.server.service.persister.dao.api.GPSCoordinatesDAO;

public class GpsCoordinatesJDBCDAO extends AbstractJDBCDAO implements GPSCoordinatesDAO {

	private static String inserSQL = "INSERT INTO gps_tracker.gps_coordinates (gps_id, gps_user_id, gps_latitude, gps_longitude) VALUES (?, ?, ? ,?)";
	private static String loadSQL = "";
	private static String updateSQL = "";
	private static String deleteSQL = "";
	
	@Override
	public boolean store(final GPSCoordinates object) {
		boolean storeSuccessful = false;
		
		getJdbcTemplate().update(
				inserSQL,
				11,
				"test",
				object.getLatitude(),
				object.getLongitude());
	 
		return storeSuccessful;
	}

	@Override
	public GPSCoordinates load(final long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(final GPSCoordinates object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(final GPSCoordinates object) {
		// TODO Auto-generated method stub
		return false;
	}

}
