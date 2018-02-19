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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    
    @Column(name = "recipe_description")
    private String recipeDescription;

    @Column(name = "cuisine_id")
    private int cuisineID;
    
    @Column(name = "prep_time")
    private String prepTime;
    
    @Column(name = "cook_time")
    private String cookTime;
    
    @Column(name = "creator_id")
    private String creatorName;
    
    public Recipe() {
    }

    public Recipe(String recipeName, Set<Ingredient> ingredients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
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
