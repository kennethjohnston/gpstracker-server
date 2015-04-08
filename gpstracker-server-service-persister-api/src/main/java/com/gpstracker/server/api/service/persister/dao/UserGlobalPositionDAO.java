package com.gpstracker.server.api.service.persister.dao;

import com.gpstracker.server.model.internal.gps.GlobalPosition;
import com.gpstracker.server.model.internal.user.UserGlobalPosition;

public interface UserGlobalPositionDAO extends GenericDAO<UserGlobalPosition> {
    
    GlobalPosition loadGlobalPositionByUserId(final long id);
}
