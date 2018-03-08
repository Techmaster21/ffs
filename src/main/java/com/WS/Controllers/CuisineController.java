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

import com.WS.Entity.Cuisine;
import com.WS.Repository.CuisineRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 *
 * @author Eric
 */
@Component
public class CuisineController {

    @Autowired
	private CuisineRepository cuisineRepository;

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public CuisineController() {
        this.server = null;
    }

    @Autowired
    public CuisineController(SocketIOServer server) {
        this.server = server;
    }
    
    @OnEvent(value = "getAllCuisines")
    public void getAllCuisines(SocketIOClient client, AckRequest request, Integer data) {
        List<Cuisine> cuisines = (List<Cuisine>) cuisineRepository.findAll();
        client.sendEvent("getAllCuisines", cuisines);
    }
    
    @OnEvent(value = "getCuisine")
    public void getCuisine(SocketIOClient client, AckRequest request, Integer data) {
    	client.sendEvent("getCuisine", cuisineRepository.findOne(data));
    }
    
    @OnEvent(value = "deleteCuisine")
    public void deleteCuisine(SocketIOClient client, AckRequest request, Integer data){
    	cuisineRepository.delete(data);
    }
    
    @OnEvent(value = "saveCuisine")
    public void saveCuisine(SocketIOClient client, AckRequest request, Cuisine data){
        cuisineRepository.save(data);
    }
}

