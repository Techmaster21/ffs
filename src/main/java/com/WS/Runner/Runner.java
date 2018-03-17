/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Runner;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.WS.Controllers.RecipeController;
import com.corundumstudio.socketio.SocketIOServer;

/**
 *
 * @author Eric
 */
@Component
public class Runner implements CommandLineRunner {

    private final SocketIOServer server;
    private RecipeController recipeController;

    @Autowired
    public Runner(SocketIOServer server, RecipeController recipeController) {
        this.server = server;
        this.recipeController = recipeController;
    }

    @Override
    public void run(String... args) throws Exception {
    		server.getNamespace("/users").addListeners(recipeController);
    		server.getNamespace("/users").addConnectListener(client -> {
    			//System.out.println("test");
    			//client.disconnect();
        	});
        server.start();
    }

    @PreDestroy
    public void destroy() {
        server.stop();
    }

}
