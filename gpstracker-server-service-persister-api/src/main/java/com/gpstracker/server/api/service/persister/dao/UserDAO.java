package com.gpstracker.server.api.service.persister.dao;

import com.gpstracker.server.model.internal.user.User;

/**
 * Defines the additional persistence functionality required by the user DAO.
 */
public interface UserDAO extends GenericDAO<User> {
    
    User loadByUserId(final String userId);

    User loadByUserName(final String userName);
    
    User loadByEmailAddress(final String emailAddress);
    
    User loadByPhoneNumber(final String phoneNumber);
}
