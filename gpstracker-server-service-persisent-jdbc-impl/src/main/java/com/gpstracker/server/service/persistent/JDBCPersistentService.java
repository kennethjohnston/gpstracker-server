package com.gpstracker.server.service.persistent;

import com.gpstracker.server.service.persistent.api.PersistentService;

/**
 * A JDBC implementation of the persistent service. The implementation will rely on specific SQL to write an object
 * to the database.
 */
public class JDBCPersistentService implements PersistentService {

	public boolean store(Object obj) {
		
		return false;
	}
	
	public Object load(String criteriaString) {
		
		return null;
	}

}
