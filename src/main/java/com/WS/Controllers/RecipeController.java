/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Recipe;
import com.WS.Repository.CuisineRepository;
import com.WS.Repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping("/api/users")
public class RecipeController {

    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CuisineRepository cuisineRepository;

    public RecipeController() {
    }

    @RequestMapping("/getRecipe")
    public Recipe getRecipe(@RequestBody Integer id) {
        return recipeRepository.findById(id).get();
    }

    @RequestMapping("/getAllRecipes")
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        return recipes;
    }

    @RequestMapping("/saveRecipe")
    public void saveRecipe(@RequestBody Recipe recipe) {
        recipeRepository.delete(recipe);
        recipeRepository.save(recipe);
        // TODO should probably return something
    }

    @RequestMapping("/deleteRecipe")
    public void deleteRecipe(@RequestBody Integer id) {
        recipeRepository.deleteById(id);
        // TODO should probably return something
    }

}
