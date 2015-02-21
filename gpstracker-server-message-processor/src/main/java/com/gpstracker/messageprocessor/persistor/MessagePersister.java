package com.gpstracker.messageprocessor.persistor;

public interface MessagePersister extends Persister {
	
	public boolean store(Object obj);

}
