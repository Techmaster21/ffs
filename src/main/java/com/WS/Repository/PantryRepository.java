package com.WS.Repository;

import com.WS.Entity.Ffser;
import com.WS.Entity.Pantry;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Eric
 */
public interface PantryRepository extends CrudRepository<Pantry, Integer> {
    
    public Pantry findByFfser(Ffser ffser);
    
}
