package com.WS.Repository;

import com.WS.Entity.User;
import com.WS.Entity.Pantry;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Eric
 */
public interface PantryRepository extends CrudRepository<Pantry, Integer> {
    
    public Pantry findByUser(User user);
    
}
