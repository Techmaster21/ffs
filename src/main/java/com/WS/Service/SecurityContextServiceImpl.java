package com.WS.Service;

import com.WS.Entity.User;
import com.WS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SecurityContextServiceImpl implements SecurityContextService {

    private final UserRepository userRepository;

    @Autowired
    public SecurityContextServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> currentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findOneByUsername(authentication.getName());
    }
}
