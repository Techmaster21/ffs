/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Runner;

import com.WS.DAOs.IngredientDAO;
import com.WS.DAOs.RecipeDAO;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eric
 */
@Component
public class Runner implements CommandLineRunner {

    private final SocketIOServer server;

    @Autowired
    public Runner(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        server.start();
        IngredientDAO ingredientDAO = new IngredientDAO();
        RecipeDAO recipeDAO = new RecipeDAO();
        System.out.println(recipeDAO.getRecipe(1));
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }

}
