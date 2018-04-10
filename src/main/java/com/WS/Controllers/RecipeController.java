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

import java.util.List;

@Component
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    private final RecipeRepository recipeRepository;
    private final SecurityContextService securityContext;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository, SecurityContextService securityContext) {
        this.recipeRepository = recipeRepository;
        this.securityContext = securityContext;
    }

    @RequestMapping("/get")
    public Recipe getRecipe(@RequestBody Integer id) {
        return recipeRepository.findById(id).get();
    }

    @RequestMapping("/getAll")
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        return recipes;
    }

    @RequestMapping("/getUsersRecipes")
    public List<Recipe> getAllUsersRecipes() {
        User currentUser = securityContext.currentUser().get();
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findByUser(currentUser);
        return recipes;
    }

    @RequestMapping("/save")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        User currentUser = securityContext.currentUser().get();
        recipe.setUser(currentUser);
        recipeRepository.delete(recipe);
        return recipeRepository.save(recipe);
    }

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
