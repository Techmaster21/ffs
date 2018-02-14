package com.WS;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private String host = "localhost"; //I will fix this later with properties file but want to make sure it works first on the server

    private Integer port = 8090;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname(host);
        config.setPort(port);
        return new SocketIOServer(config);
    }
    
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer ssrv) {
        return new SpringAnnotationScanner(ssrv);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        IngredientDAO ingredientDAO = new IngredientDAO(); This is all Test code for hibernate, works well one to many has not yet been tested so keeping until then.
//        RecipeDAO recipeDAO = new RecipeDAO();

//        Ingredient banana = new Ingredient("banana");
//        Set<Ingredient> set = new HashSet<>();
//        set.add(banana);
//        Recipe recipe = new Recipe("banana recipe", set);
//        recipeDAO.saveRecipe(recipe);
//        ingredientDAO.saveIngredient("banana");
//        System.out.println(ingredientDAO.getIngredientByName("banana"));
    }
}
