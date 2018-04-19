package com.WS.Repository;

import com.WS.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    Optional<User> findOneByUsername(String username);

    List<User> findByUsernameContaining(String username);
}
