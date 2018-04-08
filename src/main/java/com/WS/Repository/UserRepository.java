package com.WS.Repository;

import com.WS.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.List;

/**
 * 
 * 
 * @author 
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

    public Optional<User> findOneByUsername(String username);

    public List<User> findByUsernameContaining(String username);
}
