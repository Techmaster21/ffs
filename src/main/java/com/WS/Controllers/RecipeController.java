/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Recipe;
import com.WS.Entity.User;
import com.WS.Repository.RecipeRepository;
import com.WS.Service.SecurityContextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the Recipes
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    private final RecipeRepository recipeRepository;
    private final SecurityContextService securityContext;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the Recipes table.
     *
     * @param recipeRepository Repository handing Recipes table.
     */
    @Autowired
    public RecipeController(RecipeRepository recipeRepository, SecurityContextService securityContext) {
        this.recipeRepository = recipeRepository;
        this.securityContext = securityContext;
    }

    /**
     * HTTP request for getting a specific recipe from the Recipes table
     *
     * @param id The id of the recipe to return
     * @return The recipe with the requested id
     */
    @RequestMapping("/get")
    public Recipe getRecipe(@RequestBody Integer id) {
        return recipeRepository.findById(id).get();
    }

    /**
     * HTTP request for getting all of the recipes from the Recipes table
     *
     * @return All recipes in the Recipes table
     */
    @RequestMapping("/getAll")
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        return recipes;
    }

    /**
     * HTTP request for getting all recipes that were created by the user
     * requesting the recipes
     *
     * @return All recipes created by the user
     */
    @RequestMapping("/getUsersRecipes")
    public List<Recipe> getAllUsersRecipes() {
        User currentUser = securityContext.currentUser().get();
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findByUser(currentUser);
        return recipes;
    }

    /**
     * HTTP request for saving a recipe to the Recipes table
     *
     * @param recipe The recipe to be saved
     * @return The recipe saved
     */
    @RequestMapping("/save")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        User currentUser = securityContext.currentUser().get();
        recipe.setUser(currentUser);
        recipeRepository.delete(recipe);
        return recipeRepository.save(recipe);
    }

        /**
     * HTTP request for deleting a specific recipe from the Recipes table
     *
     * @param id The id of the recipe to be deleted
     */
    @RequestMapping("/delete")
    public void deleteRecipe(@RequestBody Integer id) {
        recipeRepository.deleteById(id);
        // TODO should probably return something
    }
    
    @RequestMapping("/getPublicRecipes")
    public List<Recipe> getAllPublicRecipes() {
    	List<Recipe> recipes = (List<Recipe>) recipeRepository.findByPub(true);
    	return recipes;
    	
    }
}
