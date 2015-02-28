package com.gpstracker.server.service.persister.api;

import com.gpstracker.server.service.api.ServiceOperation;

/**
 * Defines a persistent service that should provide a mechanism to store information so that it can be
 * loaded at a later time. The service should offer a CRUD operations (Create, Read, Update and Delete).
 * The persistent service should support the A.C.I.D principle (Atomicitiy, Consistency, Isolation and Durability). 
 * 
 * The time in which the write is committed to the database does not have to be explicitly at request time.
 * However, any implementations that use a batch store (etc) need to ensure the store request is made and
 * persisted to the database, and also to ensure that a read will the expected result - including any results
 * that are waiting to be written to the the database. Any  complex implementation should take into consideration
 * factors that could cause a dirty/phantom read.
 * 
 * <T> the type of the object to manage
 */
public interface Persister<T> extends ServiceOperation {

	boolean store(T t);
	
	T load(long id);
	
	boolean update(T t);
	
	boolean delete(T t);
}
