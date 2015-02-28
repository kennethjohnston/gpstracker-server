package com.gpstracker.server.service.api;

import com.gpstracker.sever.model.internal.user.User;

public interface UserService {

	boolean store(User user);
}
