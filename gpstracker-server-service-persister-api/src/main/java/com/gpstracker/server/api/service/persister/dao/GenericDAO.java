package com.gpstracker.server.api.service.persister.dao;

import com.gpstracker.server.api.service.persister.Persister;

/**
 * Defines a generic data access object. 
 *
 * @param <T> the type of the object the DAO is to manage
 */
public interface GenericDAO<T> extends Persister<T> {

}
