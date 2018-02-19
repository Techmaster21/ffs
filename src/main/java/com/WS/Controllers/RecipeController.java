/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.ClientBeans.ClientRecipe;
import com.WS.DAOs.RecipeDAO;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

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
    

}
