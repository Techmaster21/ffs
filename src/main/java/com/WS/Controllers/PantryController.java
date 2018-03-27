/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ffser;
import com.WS.Entity.Pantry;
import com.WS.Entity.PantryItem;
import com.WS.Repository.FfserRepository;
import com.WS.Repository.PantryRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eric
 */
@Component
public class PantryController implements SocketIOController {

    @Autowired
    private PantryRepository pantryRepository;
    @Autowired
    private FfserRepository ffserRepository;
    @Autowired
    LoginController loginController;

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Value("${SECRET}")
    private String secret;

    @Override
    public String getNamespace() {
        return "/users";
    }

    public PantryController() {
        this.server = null;
    }

    @Autowired
    public PantryController(SocketIOServer server) {
        this.server = server;
    }

    @OnEvent(value = "getPantry")
    public void getPantry(SocketIOClient client, AckRequest request) {
        client.sendEvent("getPantry", pantryRepository.findByFfser(
                loginController.getFfser(client.getHandshakeData().getSingleUrlParam("token"))));
    }
    
    @OnEvent(value = "savePantry")
    public void updatePantry(SocketIOClient client, AckRequest request, Pantry data){
    	data.setFfser(loginController.getFfser(client.getHandshakeData().getSingleUrlParam("token")));
    	pantryRepository.delete(data);
    	pantryRepository.save(data);
    }

}
