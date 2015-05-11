package com.gpstracker.server.service;

import com.gpstracker.server.api.service.persister.dao.UserDAO;
import com.gpstracker.server.api.service.user.UserService;
import com.gpstracker.server.model.internal.user.User;

public class DefaultUserService implements UserService {
    
    /** The user DAO persister. */
    private UserDAO persister;

    //---------------------------------------------------------------------------------------------
    @Override
    public boolean store(final User user) {
        return persister.store(user);
    }
    
    @Override
    public boolean delete(final User user) {
        return persister.delete(user);
    }

    @Override
    public boolean update(final User user) {
        return persister.update(user);
    }

    @Override
    public User loadById(final String id) {
        return persister.loadByUserId(id);
    }

    @Override
    public User loadByUserName(final String userName) {
        return persister.loadByUserName(userName);
    }
    
    @Override
    public User loadByEmail(final String email) {
        return persister.loadByEmailAddress(email);
    }

    @Override
    public User loadByPhone(final String phoneNumber) {
        return persister.loadByPhoneNumber(phoneNumber);
    }

    @Override
    public boolean isUserNameInUse(final String userName) {
        User user = loadByUserName(userName);
        return user != null;
    }
    
    @Override
    public boolean isUserEmailAddressInUse(final String emailAddress) {
        User user = loadByEmail(emailAddress);
        return user != null;
    }

    @Override
    public boolean isUserPhoneNumberInUse(final String phoneNumber) {
        User user = loadByPhone(phoneNumber);
        return user != null;
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
    public void setPersister(final UserDAO persister) {
        this.persister = persister;
    }
}
