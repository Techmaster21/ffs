package com.WS.Repository;

import com.WS.Entity.Recipe;
import com.WS.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findByUser(User user);
    List<Recipe> findByPub(boolean boo);
}
