package com.gpstracker.server.api.service.user;

import com.gpstracker.server.model.internal.user.User;

/**
 *  
 */
public interface UserService {

    boolean store(User user);
    
    boolean delete(User user);
        
    boolean update(User user);
    
    User loadById(String id);
    
    User loadByUserName(String userName);
    
    User loadByEmail(String email);
    
    User loadByPhone(String phoneNumber);
    
    boolean isUserNameInUse(String userName);

    boolean isUserEmailAddressInUse(String emailAddress);
    
    boolean isUserPhoneNumberInUse(String phoneNumber);
}
