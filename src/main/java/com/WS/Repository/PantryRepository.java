package com.WS.Repository;

import com.WS.Entity.Pantry;
import com.WS.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface PantryRepository extends CrudRepository<Pantry, Integer> {

    public Pantry findByUser(User user);

}
