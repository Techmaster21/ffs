/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Ingredient;
import com.WS.Beans.Recipe;
import com.WS.Beans.RecipeStep;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Eric
 */
public class ClientRecipe {

    private int recipeId;
    private String recipeName;
    private String recipeDescription;
    private ClientCuisine cuisine;
    private Time prepTime;
    private Time cookTime;
    private Set<ClientIngredient> ingredients;
    private Set<ClientRecipeStep> recipeSteps;
    private ClientFfser ffser;

    public ClientRecipe(int recipeId, String recipeName, String recipeDescription, ClientCuisine cuisine, Time prepTime, Time cookTime, Set<ClientIngredient> ingredients, Set<ClientRecipeStep> recipeSteps, ClientFfser ffser) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.cuisine = cuisine;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.recipeSteps = recipeSteps;
        this.ffser = ffser;
    }
    
    public ClientRecipe(Recipe recipe) {
        this.recipeId = recipe.getRecipeId();
        this.recipeName = recipe.getRecipeName();
        this.recipeDescription = recipe.getRecipeDescription();
        this.cuisine = new ClientCuisine(recipe.getCuisine());
        this.prepTime = recipe.getPrepTime();
        this.cookTime = recipe.getCookTime();
        this.ingredients = getClientIngredients(recipe.getIngredients());
        this.recipeSteps = getClientRecipeSteps(recipe.getSteps());
        this.ffser = new ClientFfser(recipe.getFfser());
    }

    private static Set<ClientIngredient> getClientIngredients(Set<Ingredient> ingredients) {
        Set<ClientIngredient> set = new HashSet<>();
        ingredients.forEach((ingredient) -> {
            set.add(new ClientIngredient(ingredient));
        });
        return set;
    }

    static Set<ClientRecipeStep> getClientRecipeSteps(Set<RecipeStep> steps) {
        Set<ClientRecipeStep> set = new HashSet<>();
        steps.forEach((step) -> {
            set.add(new ClientRecipeStep(step));
        });
        return set;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public Time getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Time prepTime) {
        this.prepTime = prepTime;
    }

    public Time getCookTime() {
        return cookTime;
    }

    public void setCookTime(Time cookTime) {
        this.cookTime = cookTime;
    }

    public Set<ClientIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<ClientIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public ClientCuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(ClientCuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Set<ClientRecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(Set<ClientRecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    

    public ClientFfser getFfser() {
        return ffser;
    }

    public void setFfser(ClientFfser ffser) {
        this.ffser = ffser;
    }

    @Override
    public String toString() {
        return "ClientRecipe{" + "recipeName=" + recipeName + ", recipeDescription=" + recipeDescription + ", cuisine=" + cuisine + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", ingredients=" + ingredients + ", recipSteps=" + recipSteps + ", ffser=" + ffser + '}';
    }

}
