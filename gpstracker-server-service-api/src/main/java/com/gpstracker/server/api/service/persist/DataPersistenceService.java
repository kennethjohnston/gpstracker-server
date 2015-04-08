package com.gpstracker.server.api.service.persist;

import java.util.Collection;

import com.gpstracker.server.api.service.ServiceOperation;

/**
 * Defines a data persistence service that provides a mechanism to store information so that it can be
 * loaded at a later time. The persistent service should support the A.C.I.D principle. Atomicitiy, 
 * Consistency, Isolation and Durability. 
 * 
 * The time in which the write is committed to the database does not have to be explicitly at request store time.
 * However, any implementations that use a batch store (etc) need to ensure the store request is made and
 * persisted to the database, and also to ensure that a read will the expected result - including any results
 * that are waiting to be written to the the database. Any  complex implementation should take into consideration
 * factors that could cause a dirty/phantom read.
 */
public interface DataPersistenceService extends ServiceOperation {

    /**
     * Stores an object 
     * @param obj the object to store
     * @return true if the object was stored successfully, false otherwise
     */
    boolean store(Object obj);
    
    /**
     * Stores a collection of objects to the database.
     * @param objCollection the object collection to store
     * @return true if the object collection was stored successfully, false otherwise
     */
    boolean store(Collection<Object> objCollection);
    
    /**
     * Loads an object
     * @param criteriaString the requirements to load the object
     * @return the result object from the requirements, may be null
     */
    Object load(String criteriaString);
    
    /**
     * Loads a collection of objects
     * @param criteriaString the requirements to load the object colletion
     * @return the result object collection from the requirements, may be null
     */
    Collection<Object> loadCollection(String criteriaString);

}