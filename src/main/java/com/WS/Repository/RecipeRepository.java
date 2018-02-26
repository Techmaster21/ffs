package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>{

}
