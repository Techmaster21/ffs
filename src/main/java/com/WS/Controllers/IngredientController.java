/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ingredient;
import com.WS.Repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the Ingredients
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    /**
     * Repository handling ingredients table.
     */
    private final IngredientRepository ingredientRepository;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the Ingredients table.
     *
     * @param ingredientRepository Repository handing Ingredients table.
     */
    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /**
     * HTTP request for getting a specific ingredient from the table
     *
     * @param id the id of the ingredient to be searched in the Ingredients
     * database.
     * @return The ingredient requested
     */
    @RequestMapping("/get")
    public Ingredient getIngredient(@RequestBody Integer id) {
        return ingredientRepository.findById(id).get();
    }

    /**
     * HTTP request for getting all of the ingredients from the table
     * @return all of the Ingredients in the table
     */
    @RequestMapping("/getAll")
    public List<Ingredient> getAllIngredients() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

}
