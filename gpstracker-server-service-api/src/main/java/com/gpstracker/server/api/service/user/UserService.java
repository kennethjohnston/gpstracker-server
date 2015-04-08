package com.gpstracker.server.api.service.user;

import com.gpstracker.server.model.internal.user.User;

/**
 *  
 */
public interface UserService {

    boolean store(User user);
    
    boolean delete(User user);
        
    boolean update(User user);
    
    User loadById(long id);
    
    User loadByEmail(String email);
    
    User loadByPhone(String phoneNumber);
    
    boolean isUserEmailAddressInUse(String emailAddress);
    
    boolean isUserPhoneNumberInUse(String phoneNumber);
}
