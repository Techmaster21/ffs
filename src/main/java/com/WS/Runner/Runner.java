/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Runner;

import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.WS.Controllers.SocketIOController;
import com.corundumstudio.socketio.SocketIOServer;

/**
 *
 * @author Eric
 */
@Component
public class Runner implements CommandLineRunner {

    private final SocketIOServer server;
    @Autowired
    private List<SocketIOController> controllers;

    @Autowired
    public Runner(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        // namespace stuff. It's here and not in the server creation because the controllers need the server to be
    		// created already in order to be instantiated.
    		server.addNamespace("/users");
		// Scan for Socketio annotations
		for( SocketIOController c : controllers) {
			String namespace = c.getNamespace();
			if (!namespace.isEmpty()) {
				server.getNamespace(namespace).addListeners(c);
			} else {
				server.addListeners(c);
			}
		}
		server.getNamespace("/users").addConnectListener(client -> {
			// Authentication hooplah goes here
			System.out.println("You connected to the users namespace. Gratz m8!");
    		});
		
        server.start();
    }

    @PreDestroy
    public void destroy() {
        server.stop();
    }

}
