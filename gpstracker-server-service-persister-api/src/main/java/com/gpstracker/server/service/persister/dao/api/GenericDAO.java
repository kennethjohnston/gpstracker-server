package com.gpstracker.server.service.persister.dao.api;

import com.gpstracker.server.service.persister.api.Persister;

/**
 * Defines a generic data access object. 
 *
 * @param <T> the type of the object the DAO is to manage
 */
public interface GenericDAO<T> extends Persister<T> {

}
