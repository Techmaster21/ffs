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

@Component
@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @RequestMapping("/get")
    public Ingredient getIngredient(@RequestBody Integer id) {
        return ingredientRepository.findById(id).get();
    }

    @RequestMapping("/getAll")
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        return ingredients;
    }

    @RequestMapping("/delete")
    public void deleteIngredient(@RequestBody Integer id) {
        ingredientRepository.deleteById(id);
        // TODO should probably return something
    }

    @RequestMapping("/save")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
