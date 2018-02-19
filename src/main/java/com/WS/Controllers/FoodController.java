/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.DAOs.FoodDAO;
import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eric
 */
@Component
public class FoodController {

    private final SocketIOServer server;
    private final FoodDAO foodDAO = new FoodDAO();
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public FoodController() {
        this.server = null;
    }

    @Autowired
    public FoodController(SocketIOServer server) {
        this.server = server;
    }

}
