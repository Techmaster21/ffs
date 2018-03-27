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

import com.WS.Entity.Food;
import com.WS.Entity.Food;
import com.WS.Entity.Recipe;
import com.WS.Repository.FoodRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 *
 * @author Samuel
 */
@Component
public class FoodDatabaseController implements SocketIOController {
	
	@Autowired
	private FoodRepository foodDatabaseRepository;

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public FoodDatabaseController() {
        this.server = null;
    }

    @Autowired
    public FoodDatabaseController(SocketIOServer server) {
        this.server = server;
    }
    
    public String getNamespace() {
		return "/users";
    }


    @OnEvent(value = "getFoodItemsByName")
    public void getFoods(SocketIOClient client, AckRequest request, String data) {
    	
    }
    
    @OnEvent(value = "getAllFoodItems")
    public void getAllFoodItems(SocketIOClient client, AckRequest request, Integer data){
//        List<FoodDatabase> foodItems = (List<FoodDatabase>) foodDatabaseRepository.findAll();
//        client.sendEvent("getAllFoodItems", foodItems);
    }
}
