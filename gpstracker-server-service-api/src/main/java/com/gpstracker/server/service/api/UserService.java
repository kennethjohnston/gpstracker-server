package com.gpstracker.server.service.api;

import com.gpstracker.server.model.internal.user.User;

public interface UserService {

	boolean store(User user);
}
