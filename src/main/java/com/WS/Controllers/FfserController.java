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

import com.WS.Entity.Ffser;
import com.WS.Repository.FfserRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Eric
 */
@Component
public class FfserController implements SocketIOController {

    @Autowired
	private FfserRepository ffserRepository;
	
    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public FfserController() {
        this.server = null;
    }
    
    @Autowired
    public FfserController(SocketIOServer server) {
        this.server = server;
    }
    
    public String getNamespace() {
		return "/users";
    }
    
    @OnEvent(value = "saveFfser")
    public void saveFfser(SocketIOClient client, AckRequest request, Ffser data){
	    	//TODO: Create Account
	    	ffserRepository.save(data);
    }
    
    @OnEvent(value = "deleteFfser")
    public void deleteFfser(SocketIOClient client, AckRequest request, Integer data){
    		ffserRepository.delete(data);
    }
    
    
}
