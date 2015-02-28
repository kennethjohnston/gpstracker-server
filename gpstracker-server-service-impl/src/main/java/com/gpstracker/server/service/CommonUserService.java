package com.gpstracker.server.service;

import com.gpstracker.server.service.api.UserService;
import com.gpstracker.server.service.persister.api.Persister;
import com.gpstracker.server.service.persister.dao.api.UserDAO;
import com.gpstracker.sever.model.internal.user.User;

public class CommonUserService implements UserService {
	
	private UserDAO persister;

	@Override
	public boolean store(User user) {
		return persister.store(user);
	}

	//---------------------------------------------------------------------------------------------
	// Getters and Setters.
	/**
	 * @return the persister
	 */
	public UserDAO getPersister() {
		return persister;
	}

	/**
	 * @param persister the persister to set
	 */
	public void setPersister(UserDAO persister) {
		this.persister = persister;
	}
}