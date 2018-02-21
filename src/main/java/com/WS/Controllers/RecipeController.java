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

import com.WS.Entity.Ffser;
import com.WS.Entity.Recipe;
import com.WS.Repository.RecipeRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 *
 * @author Eric
 */
@Component
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public RecipeController() {
        this.server = null;        
    }
    
    @Autowired
    public RecipeController(SocketIOServer server) {
        this.server = server;  
    }

    @OnEvent(value = "getRecipe")
    public void getRecipe(SocketIOClient client, AckRequest request, Integer data) {
        client.sendEvent("getRecipe", recipeRepository.findOne(data));
    }
    
    @OnEvent(value = "getAllRecipes")
    public void getAllRecipes(SocketIOClient client, AckRequest request, Integer data) {
    		List<Recipe> recipes = (List<Recipe>)recipeRepository.findAll();
        client.sendEvent("getAllRecipes", recipes);
    }
    
    @OnEvent(value = "saveRecipe")
    public void saveRecipe(SocketIOClient client, AckRequest request, Recipe data){
//	    		Ffser f = new Ffser();
//	    		f.setFfser(3);
//	    		data.setFfser(f);
	    	System.out.println(data);
	    	recipeRepository.save(data);
    }
    /*
    @OnEvent(value = "deleteRecipe")
    public void deleteRecipe(SocketIOClient client, AckRequest request, Integer data){
    	recipeDAO.deleteRecipe(data);
    }
    
    @OnEvent(value = "updateRecipe")
    public void updateRecipe(SocketIOClient client, AckRequest request, Integer data){
    	ClientRecipe recipe = recipeDAO.getRecipe(data);
    	Recipe rec = new Recipe(recipe, ffserDAO.getFfser(1));
    	recipeDAO.updateRecipe(rec);
    }
    */
}
