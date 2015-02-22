package com.gpstracker.server.service.persistent.api;

import com.gpstracker.server.service.api.ServiceOperation;

/**
 * Defines a persistent service that should provide a mechanism to store information so that it can be
 * loaded at a later time. The persistent service should support the A.C.I.D principle. Atomicitiy, 
 * Consistency, Isolation and Durability. 
 * 
 * The time in which the write is committed to the database does not have to be explicitly at request time.
 * However, any implementations that use a batch store (etc) need to ensure the store request is made and
 * persisted to the database, and also to ensure that a read will the expected result - including any results
 * that are waiting to be written to the the database. Any  complex implementation should take into consideration
 * factors that could cause a dirty/phantom read.
 */
public interface PersistentService extends ServiceOperation {
	///////////////////////////////////////////////////////////////////////////////////////////////
	// TODO: Use type erasure via generics? Or use an object based input?
	///////////////////////////////////////////////////////////////////////////////////////////////

	boolean store(Object obj);
	
	Object load(String criteriaString);

}
