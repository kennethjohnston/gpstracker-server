package com.gpstracker.server.service;

import com.gpstracker.server.api.service.persister.dao.UserDAO;
import com.gpstracker.server.api.service.user.UserService;
import com.gpstracker.server.model.internal.user.User;

public class DefaultUserService implements UserService {
    
    /** The user DAO persister. */
    private UserDAO persister;

    @Override
    public boolean store(User user) {
        return persister.store(user);
    }
    
    @Override
    public boolean delete(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User loadById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User loadByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User loadByPhone(String phoneNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isUserEmailAddressInUse(String emailAddress) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isUserPhoneNumberInUse(String phoneNumber) {
        // TODO Auto-generated method stub
        return false;
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
