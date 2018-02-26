package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer>{

}
