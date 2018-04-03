package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>{

    public User findByUsername(String username);
    public Optional<User> findOneByUsername(String username);
}
