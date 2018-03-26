package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.FoodDatabase;
import java.util.List;

public interface FoodDatabaseRepository extends CrudRepository<FoodDatabase, Integer>{

    public List<FoodDatabase> findByNameContaining(String fooddatabase);
}