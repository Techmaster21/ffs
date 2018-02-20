/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Beans.Ingredient;
import com.WS.ClientBeans.ClientRecipe;
import com.WS.ClientBeans.ClientUnit;
import com.WS.DAOs.IngredientDAO;
import com.WS.DAOs.RecipeDAO;
import com.WS.DAOs.UnitDAO;
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
public class UnitController {

    private final SocketIOServer server;
    private final UnitDAO unitDAO = new UnitDAO();
    private final IngredientDAO ingredientDAO = new IngredientDAO();
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public UnitController() {
        this.server = null;
    }

    @Autowired
    public UnitController(SocketIOServer server) {
        this.server = server;
    }

    
    @OnEvent(value = "getAllUnits")
    public void getAllUnits(SocketIOClient client, AckRequest request, Integer data) {
        List<ClientUnit> units = unitDAO.getAllUnits();
        client.sendEvent("getAllUnits", units);
    }
}
