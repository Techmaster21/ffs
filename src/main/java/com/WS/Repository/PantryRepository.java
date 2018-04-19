package com.WS.Repository;

import com.WS.Entity.Pantry;
import com.WS.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PantryRepository extends CrudRepository<Pantry, Integer> {

    Pantry findByUser(User user);
    @Transactional
    Integer deleteByUser(User user);
}
