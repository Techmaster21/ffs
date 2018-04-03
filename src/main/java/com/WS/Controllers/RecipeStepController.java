/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.RecipeStep;
import com.WS.Repository.RecipeStepRepository;
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
@RequestMapping("/api/step")
public class RecipeStepController {

    private final Logger logger = LoggerFactory.getLogger(RecipeStepController.class);
    private final RecipeStepRepository recipeStepRepository;

    @Autowired
    public RecipeStepController(RecipeStepRepository recipeStepRepository) {
        this.recipeStepRepository = recipeStepRepository;
    }

    @RequestMapping("/get")
    public RecipeStep getRecipeStep(@RequestBody Integer id) {
        return recipeStepRepository.findById(id).get();
    }

    @RequestMapping("/getAll")
    public List<RecipeStep> getAllRecipeSteps() {
        List<RecipeStep> recipeSteps = (List<RecipeStep>) recipeStepRepository.findAll();
        return recipeSteps;
    }

    @RequestMapping("/delete")
    public void deleteRecipeStep(@RequestBody Integer id) {
        recipeStepRepository.deleteById(id);
        // TODO should probably return something
    }

    @RequestMapping("/save")
    public RecipeStep saveRecipeStep(@RequestBody RecipeStep recipeStep) {
        return recipeStepRepository.save(recipeStep);
    }
}
