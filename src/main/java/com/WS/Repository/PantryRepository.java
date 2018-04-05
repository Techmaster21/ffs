package com.WS.Repository;

import com.WS.Entity.Pantry;
import com.WS.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PantryRepository extends CrudRepository<Pantry, Integer> {

    public Pantry findByUser(User user);
    @Transactional
    public Integer deleteByUser(User user);
}
