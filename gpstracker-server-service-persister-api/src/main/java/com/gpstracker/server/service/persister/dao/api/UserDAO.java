package com.gpstracker.server.service.persister.dao.api;

import com.gpstracker.server.model.internal.user.User;

/**
 * 
 */
public interface UserDAO extends GenericDAO<User> {

    User loadByUserName(final String userName);
    
    User loadByEmailAddress(final String emailAddress);
    
    User loadByPhoneNumber(final String phoneNumber);
}
