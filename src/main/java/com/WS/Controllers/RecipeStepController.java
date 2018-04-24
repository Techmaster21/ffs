/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ingredient;
import com.WS.Entity.RecipeStep;
import com.WS.Repository.IngredientRepository;
import com.WS.Repository.RecipeStepRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the RecipeSteps
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/step")
public class RecipeStepController {

    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    /**
     * Repository handling RecipeStep table.
     */
    private final RecipeStepRepository recipeStepRepository;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the RecipeStep table.
     *
     * @param recipeStepRepository Repository handing RecipeStep table.
     */
    @Autowired
    public RecipeStepController(RecipeStepRepository recipeStepRepository) {
        this.recipeStepRepository = recipeStepRepository;
    }

    /**
     * HTTP request for getting a specific step from the table
     *
     * @param id the id of the ingredient to be searched in the RecipeStep
     * database.
     * @return The step requested
     */
    @RequestMapping("/get")
    public RecipeStep getRecipeStep(@RequestBody Integer id) {
        return recipeStepRepository.findById(id).get();
    }

    @RequestMapping("/delete")
    public void deleteRecipeStep(@RequestBody Integer id) {
        recipeStepRepository.deleteById(id);
    }

    /**
     * HTTP request for getting all of the steps from the table
     * @return all of the RecipeSteps in the table
     */
    @RequestMapping("/getAll")
    public List<RecipeStep> getAllRecipeSteps() {
        return (List<RecipeStep>) recipeStepRepository.findAll();
    }

}
