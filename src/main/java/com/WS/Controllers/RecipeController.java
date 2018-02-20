/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Beans.Cuisine;
import com.WS.Beans.Ffser;
import com.WS.Beans.Recipe;
import com.WS.ClientBeans.ClientFfser;
import com.WS.ClientBeans.ClientRecipe;
import com.WS.DAOs.FfserDAO;
import com.WS.DAOs.RecipeDAO;
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
public class RecipeController {

	private final SocketIOServer server;
    private final RecipeDAO recipeDAO = new RecipeDAO();
    private final FfserDAO ffserDAO = new FfserDAO();
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
        ClientRecipe recipe = recipeDAO.getRecipe(data);
        client.sendEvent("getRecipe", recipe);
    }
    
    @OnEvent(value = "getAllRecipes")
    public void getAllRecipes(SocketIOClient client, AckRequest request, Integer data) {
        List<ClientRecipe> recipe = recipeDAO.getAllRecipes();
        client.sendEvent("getAllRecipes", recipe);
    }
    
    @OnEvent(value = "saveRecipe")
    public void saveRecipe(SocketIOClient client, AckRequest request, Integer data){
    	ClientRecipe recipe = recipeDAO.getRecipe(data);
    	Recipe rec = new Recipe(recipe, ffserDAO.getFfser(1));
    	recipeDAO.saveRecipe(rec);
    }
    
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
}
