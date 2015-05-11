package com.gpstracker.server.core.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gpstracker.server.api.core.CallbackResultStore;
import com.gpstracker.server.core.model.CallbackProcessingResult;

/**
 * Result store for the callback response. This implementation will rely on a relation
 * database to store the objects, it is assumed that the database will be accessible by
 * all instances of the application. 
 * 
 * Note: This implementation stores the response object as a blob in the database. This 
 *       was implemented this way as the type of the result is unknown and therefore the
 *       requirement to maintain SQL inserts/selects for each object type was not a viable
 *       option.
 */
public class CallbackDatabaseStore implements CallbackResultStore {
    
    /** The SQL to store a callback response. */
    private static final String STORE_RESPONSE_SQL = "INSERT INTO gps_tracker.callback_response_store(response_id, user_id, response_status, response_object_type, response_object) VALUES (?, ?, ?, ?, ?)";
    /** . */
    private static final String GET_RESPONSE_SQL = "SELECT response_object_type, response_object FROM gps_tracker.callback_response_store WHERE response_id = ?";
    /** .*/
    private JdbcTemplate jdbcTemplate; 
    
    /**
     * Stores a call back response.
     * 
     * @param processingResult the callback response to store
     * @return true if the result was stored, false otherwise
     */
    @Override
    public boolean store(final CallbackProcessingResult processingResult) {        
        boolean successful = true;
        try {
            jdbcTemplate.update(
                    STORE_RESPONSE_SQL,
                    processingResult.getId(),
                    processingResult.getUserId(),
                    processingResult.getStatus().toString(),
                    processingResult.getResponseResultClassType(),
                    processingResult.getResponseResult());
        } catch (Exception ex) {
            successful = false;
        }
        
        return successful;
    }

    /**
     * Gets retrieves a callback response.
     * 
     * @param id the identifier of the callback response to retieve
     * @return the callback response object, may return null
     */
    @Override
    public CallbackProcessingResult get(final String id) {
        CallbackProcessingResult result = null;
        try {
            result = jdbcTemplate.queryForObject(
                    GET_RESPONSE_SQL,
                    new Object[] {id},
                    new CallbackProcessingResultRowMapper());
        } catch(EmptyResultDataAccessException ex) {
            // Ignore
        } catch (DataAccessException dEx) {
            // Ignore
        }
        
        return result;
    }

    /**
     * Gets the jdbcTemplate.
     * 
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * Sets the jdbcTemplate.
     * 
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * Private inner class for row mapping, this is inner as it specific to this implementation
     */
    private class CallbackProcessingResultRowMapper implements RowMapper<CallbackProcessingResult> {

        /**
         * Constructor
         */
        public CallbackProcessingResultRowMapper() {            
        }
        
        /**
         * Maps database result set to a CallbackProcessingResult.
         * 
         * @param rs the ResultSet to map
         * @param rowNum the number of the current row
         * @return the result object for the current row
         * @throws SQLException if a SQLException if an error SQL occurs
         */
        @Override
        public CallbackProcessingResult mapRow(ResultSet rs, int rowNum) throws SQLException {
            CallbackProcessingResult result = new CallbackProcessingResult();
            result.setResponseResultClassType(rs.getString("response_object_type"));
            result.setResponseResult(rs.getObject("response_object"));
            
            // The object was stored to the database as a binary object
            // need to load the bytes and pass to an input stream that 
            // read read the bytes and de-serialise to an object again.
            Blob blob = rs.getBlob("response_object");            
            if (blob != null) {
                try {
                    InputStream intputStream = blob.getBinaryStream();
                    ObjectInputStream databaseBlobStream = new ObjectInputStream(intputStream);
                    Object processingResult = databaseBlobStream.readObject();
                    result.setResponseResult(processingResult);
                } catch(IOException ioEx) {
                    // Ignore
                } catch(ClassNotFoundException e) {
                    // Ignore
                }
            }            
            
            return result;
        }        
    }
}
