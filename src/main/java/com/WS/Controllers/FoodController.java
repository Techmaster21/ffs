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
import com.WS.Entity.Recipe;
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
public class FoodController implements SocketIOController {

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

    public String getNamespace() {
        return "/users";
    }

//    @OnEvent(value = "saveFood")
//    public void getFoods(SocketIOClient client, AckRequest request, Food data) {
//        System.out.println(data);
//    }
    @OnEvent(value = "getFoodsByName")
    public void getFoods(SocketIOClient client, AckRequest request, String data) {

    }

    public void getAllFoods(SocketIOClient client, AckRequest request, Integer data) {
        List<Food> foods = (List<Food>) foodRepository.findAll();
        client.sendEvent("getAllFoods", foods);
    }
}
