package com.gpstracker.server.api.service.persister.dao;

import com.gpstracker.server.model.internal.user.User;

/**
 * 
 */
public interface UserDAO extends GenericDAO<User> {

    User loadByUserName(final String userName);
    
    User loadByEmailAddress(final String emailAddress);
    
    User loadByPhoneNumber(final String phoneNumber);
}
