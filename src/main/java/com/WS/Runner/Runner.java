/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.WS.Runner;
//
//import java.util.List;
//
//import javax.annotation.PreDestroy;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.WS.Repository.FfserRepository;
//import com.WS.Repository.PantryItemsRepository;
//import com.corundumstudio.socketio.SocketIOServer;
//import io.jsonwebtoken.Jwts;
//import org.springframework.beans.factory.annotation.Value;
//
///**
// *
// * @author Eric
// */
//@Component
//public class Runner implements CommandLineRunner {
//
//    @Value("${SECRET}")
//    private String secret;
//
//    private final SocketIOServer server;
//    @Autowired
//    private List<SocketIOController> controllers;
//
//    @Autowired
//    public Runner(SocketIOServer server) {
//        this.server = server;
//    }
//
//    @Autowired
//    private PantryItemsRepository pantryRepository;
//    @Autowired
//    private FfserRepository ffserRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // namespace stuff. It's here and not in the server creation because the controllers need the server to be
//        // created already in order to be instantiated.
//        server.addNamespace("/users");
//        // Scan for Socketio annotations
//        for (SocketIOController c : controllers) {
//            String namespace = c.getNamespace();
//            if (!namespace.isEmpty()) {
//                server.getNamespace(namespace).addListeners(c);
//            } else {
//                server.addListeners(c);
//            }
//        }
//        server.getNamespace("/users").addConnectListener(client -> {
//            String token = client.getHandshakeData().getSingleUrlParam("token");
//            if (token == null) {
//                client.disconnect();
//            } else {
//                try {
//                    String user = Jwts.parser()
//                            .setSigningKey(secret.getBytes())
//                            .parseClaimsJws(token)
//                            .getBody()
//                            .getSubject();
//                    if (user == null) {
//                        client.disconnect();
//                    }
//                } catch (Exception e) {
//                    System.out.println(e);
//                    client.disconnect();
//                }
//            }
//        });
//        System.out.println(pantryRepository.findAll());
//        server.start();
//    }
//
//    @PreDestroy
//    public void destroy() {
//        server.stop();
//    }
//
//}
