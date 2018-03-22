package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Ffser;
import com.WS.Entity.FoodDatabase;

public interface FoodDatabaseRepository extends CrudRepository<Ffser, Integer>{

    public FoodDatabase findByUsername(String fooddatabase);
}