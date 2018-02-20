/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Beans;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.WS.ClientBeans.ClientIngredient;
import com.WS.ClientBeans.ClientRecipe;
import com.WS.ClientBeans.ClientRecipeStep;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int recipeId;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "recipe_description")
    private String recipeDescription; 
    
    @OneToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;
    
    @Column(name = "prep_time")
    private Time prepTime;
    
    @Column(name = "cook_time")
    private Time cookTime;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<RecipeStep> steps = new HashSet<>();
    
    @ManyToOne
    @JoinColumn (name = "creator_id")
    private Ffser ffser;
    
    public Recipe() {
    }
    
    public Recipe(String recipe_name, String recipe_description, Cuisine cuisine, Time prepTime, Time cookTime, Set<Ingredient> ingredients, Set<RecipeStep> recipeSteps, Ffser ffser) {
    	this.recipeName = recipe_name;
    	this.recipeDescription = recipe_description;
    	this.cuisine = cuisine;
    	this.prepTime = prepTime;
    	this.cookTime = cookTime;
    	this.ingredients = ingredients;
    	this.steps = recipeSteps;
    	this.ffser = ffser;
    }
    
    public Recipe(ClientRecipe recipe, Ffser ffser){
    	Set<Ingredient> ing = new HashSet<>();
    	Set<ClientIngredient> ci = recipe.getIngredients();
    	Set<RecipeStep> rs = new HashSet<>();
    	Set<ClientRecipeStep> crs = recipe.getSteps();
    	for(ClientIngredient clin : ci){
    		ing.add(new Ingredient(clin));
    	}
    	for(ClientRecipeStep cris : crs){
    		rs.add(new RecipeStep(cris));
    	}
    	
    	this.recipeName = recipe.getName();
    	this.recipeDescription = recipe.getDescription();
    	this.cuisine = new Cuisine(recipe.getCuisine());
    	this.prepTime = recipe.getPrepTime();
    	this.cookTime = recipe.getCookTime();
    	this.ingredients = ing;
    	this.steps = rs;
    	this.ffser = ffser;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Set<RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(Set<RecipeStep> steps) {
        this.steps = steps;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Ffser getFfser() {
        return ffser;
    }

    public void setFfser(Ffser ffser) {
        this.ffser = ffser;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.recipeId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (this.recipeId != other.recipeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recipe{" + "recipeId=" + recipeId + ", recipeName=" + recipeName + ", recipeDescription=" + recipeDescription + ", cuisine=" + cuisine + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", ingredients=" + ingredients + '}';
    }

}
