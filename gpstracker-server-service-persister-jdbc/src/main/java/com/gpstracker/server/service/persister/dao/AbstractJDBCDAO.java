package com.gpstracker.server.service.persister.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * An abstract implementation of a DAO - Data Access Object. The implemention uses the Spring
 * JDBC template to handle the boiler plate code of handling and establishing connections.
 */
public class AbstractJDBCDAO {
	
	private JdbcTemplate jdbcTemplate;

	/**
	 * Get the JDBC template.
	 * 
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	/**
	 * Set the JDBC template.
	 * 
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
