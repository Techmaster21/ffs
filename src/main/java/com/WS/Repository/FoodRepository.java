package com.WS.Repository;

import com.WS.Entity.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Integer> {

    public List<Food> findByNameContaining(String fooddatabase);
}