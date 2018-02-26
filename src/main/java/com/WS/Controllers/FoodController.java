/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.WS.Entity.Food;
import com.WS.Repository.FoodRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 *
 * @author Eric
 */
@Component
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public FoodController() {
        this.server = null;
    }

    @Autowired
    public FoodController(SocketIOServer server) {
        this.server = server;
    }

    @OnEvent(value = "saveFood")
    public void getIngredients(SocketIOClient client, AckRequest request, Food data) {
        System.out.println(data);
    }

}
