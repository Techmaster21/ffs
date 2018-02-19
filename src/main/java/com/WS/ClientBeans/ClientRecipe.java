/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Ingredient;
import com.WS.Beans.Recipe;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Eric
 */
public class ClientRecipe {

    private String recipeName;
    private String recipeDescription;
    private String cuisine;
    private Time prepTime;
    private Time cookTime;
    private Set<ClientIngredient> clientIngredients;
    private ClientFfser clientFfser;

    public ClientRecipe(String recipeName, String recipeDescription, String cuisine, Time prepTime, Time cookTime, Set<ClientIngredient> clientIngredients, ClientFfser clientFfser) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.cuisine = cuisine;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.clientIngredients = clientIngredients;
        this.clientFfser = clientFfser;
    }

    private static Set<ClientIngredient> getClientIngredients(Set<Ingredient> ingredients){
        Set<ClientIngredient> set = new HashSet<>();
        ingredients.forEach((ingredient) -> {
            set.add(ClientIngredient.fromIngredient(ingredient));
        });
        return set;
    }
    
    public static ClientRecipe fromRecipe(Recipe recipe){
        return new ClientRecipe(recipe.getRecipeName(), recipe.getRecipeDescription(), recipe.getCuisine().getCuisineName(), recipe.getPrepTime(), recipe.getCookTime(), 
                getClientIngredients(recipe.getIngredients()), ClientFfser.fromFfser(recipe.getFfser()));
    }
}
