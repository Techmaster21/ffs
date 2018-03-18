/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ingredient;
import com.WS.Repository.IngredientRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eric
 */
@Component
public class IngredientController implements SocketIOController {

	private IngredientRepository ingredientRepository;
    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public IngredientController() {
        this.server = null;
    }

    @Autowired
    public IngredientController(SocketIOServer server) {
        this.server = server;
    }
    
    public String getNamespace() {
		return "/users";
    }

    @OnEvent(value = "getIngredient")
    public void getIngredient(SocketIOClient client, AckRequest request, Integer data) {
    		client.sendEvent("getIngredient", ingredientRepository.findOne(data));
    }
    
    @OnEvent(value = "getAllIngredients")
    public void getAllIngredients(SocketIOClient client, AckRequest request, Integer data) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        client.sendEvent("getAllIngredients", ingredients);
    }
    
    @OnEvent(value = "deleteIngredient")
    public void deleteIngredient (SocketIOClient client, AckRequest request, Integer data) {
    		ingredientRepository.delete(data);
    }
    
    @OnEvent(value = "createIngredient")
    public void createIngredient (SocketIOClient client, AckRequest request, Ingredient data) {
    		ingredientRepository.save(data);
    }
}
