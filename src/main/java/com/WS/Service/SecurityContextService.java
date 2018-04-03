package com.WS.Service;

import com.WS.Entity.User;

import java.util.Optional;

public interface SecurityContextService {

    Optional<User> currentUser();

}