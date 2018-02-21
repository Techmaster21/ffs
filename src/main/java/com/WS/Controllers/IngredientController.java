/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ingredient;
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
public class IngredientController {

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public IngredientController() {
        this.server = null;
    }

    @Autowired
    public IngredientController(SocketIOServer server) {
        this.server = server;
    }

    @OnEvent(value = "getIngredient")
    public void getIngredients(SocketIOClient client, AckRequest request, Integer data) {
        //Ingredient ingredient = ingredientDAO.getIngredientById(data);
        //client.sendEvent("getIngredient", ingredient);
    }
}
