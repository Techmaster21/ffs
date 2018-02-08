package com.WS.Application;

import com.WS.Beans.Ingredient;
import com.WS.Beans.Recipe;
import com.WS.DAOs.IngredientDAO;
import com.WS.DAOs.RecipeDAO;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import java.util.HashSet;
import java.util.Set;;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private String host = "localhost";

    private Integer port = 8080;
    
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname(host);
        config.setPort(port);
        return new SocketIOServer(config);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        IngredientDAO ingredientDAO = new IngredientDAO();
//        RecipeDAO recipeDAO = new RecipeDAO();
        
//        Ingredient banana = new Ingredient("banana");
//        Set<Ingredient> set = new HashSet<>();
//        set.add(banana);
//        Recipe recipe = new Recipe("banana recipe", set);
//        recipeDAO.saveRecipe(recipe);
//        ingredientDAO.saveIngredient("banana");
        
        System.out.println(ingredientDAO.getIngredientByName("banana"));
    }
}
