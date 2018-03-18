/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.WS.Entity.Ingredient;
import com.WS.Entity.RecipeStep;
import com.WS.Entity.Unit;
import com.WS.Repository.RecipeStepRepository;
import com.WS.Repository.UnitRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;


@Component
public class RecipeStepController implements SocketIOController {
	
	@Autowired
	private RecipeStepRepository recipeStepRepository;

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public RecipeStepController() {
        this.server = null;
    }

    @Autowired
    public RecipeStepController(SocketIOServer server) {
        this.server = server;
    }
    
    public String getNamespace() {
		return "/users";
    }
    
    @OnEvent(value = "getRecipeStep")
    public void getRecipeStep(SocketIOClient client, AckRequest request, Integer data) {
    		client.sendEvent("getRecipeStep", recipeStepRepository.findOne(data));
    }
    
    @OnEvent(value = "getAllRecipeSteps")
    public void getAllRecipeSteps(SocketIOClient client, AckRequest request, Integer data) {
        List<RecipeStep> recipeSteps = (List<RecipeStep>) recipeStepRepository.findAll();
        client.sendEvent("getAllRecipeSteps", recipeSteps);
    }
    
    @OnEvent(value = "deleteRecipeStep")
    public void deleteRecipeStep(SocketIOClient client, AckRequest request, Integer data) {
    		recipeStepRepository.delete(data);
    }
    
    @OnEvent(value = "saveRecipeStep")
    public void saveRecipeStep(SocketIOClient client, AckRequest request, RecipeStep data) {
    		recipeStepRepository.save(data);
    }
}
