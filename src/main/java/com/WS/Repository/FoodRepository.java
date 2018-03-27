package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Food;
import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Integer>{

    public List<Food> findByNameContaining(String fooddatabase);
}