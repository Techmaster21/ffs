/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Recipe object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "recipes")
public class Recipe {

	/**
	 * Id of this Recipe
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int id;

    /**
     * Name of this Recipe
     */
    @Column(name = "recipe_name")
    private String name;

    /**
     * Text description of this Recipe
     */
    @Column(name = "recipe_description")
    private String description;

    /**
     * Cuisine type of this Recipe
     */
    @OneToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    /**
     * Prepping time for this Recipe
     */
    @Column(name = "prep_time")
    private Duration prepTime;

    /**
     * Cooking time for this Recipe
     */
    @Column(name = "cook_time")
    private Duration cookTime;

    /**
     * Ingredients in this Recipe
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recipe")
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    /**
     * RecipeSteps of this Recipe
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recipe")
    @JsonManagedReference
    private List<RecipeStep> steps = new ArrayList<>();

    /**
     * User id for this Recipe
     */
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user;
    
    @Column(name = "public")
    private boolean pub;

    /**
     *Representation of a Recipe object in database.
     */
    public Recipe() {
    }

    /**
     * Representation of a Recipe object in database with given name, description, cuisine, prep time, cook time, ingredients, recipe steps, and user.
     * @param name Name of Recipe
     * @param description Description of Recipe
     * @param cuisine Cuisine of Recipe
     * @param prepTime Prepping time of Recipe
     * @param cookTime Cooking time of Recipe
     * @param ingredients Ingredients of Recipe
     * @param steps RecipeSteps in Recipe
     * @param user User Recipe belongs to
     */
    public Recipe(String name, String description, Cuisine cuisine, Duration prepTime, Duration cookTime,
                  List<Ingredient> ingredients, List<RecipeStep> steps, User user, boolean pub) {
        this.name = name;
        this.description = description;
        this.cuisine = cuisine;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.steps = steps;
        this.user = user;
        this.pub = pub;
    }

    /**
     * Returns a string representation of this Recipe object.
     * @return String representation of this Recipe object. 
     */
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cuisine=" + cuisine +
                ", prepTime='" + prepTime + '\'' +
                ", cookTime='" + cookTime + '\'' +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", user=" + user +
                '}';
    }

    /**
     * Returns a hash code value for this Recipe object.
     * @return integer that is the hash code for this Recipe object
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        return hash;
    }
    
    /**
     * Indicates whether some other object is "equal to" this Recipe object.
     * @param obj object being tested for equality with this Recipe.
     * @return return true if obj and this Recipe are equivalent.  False if not. 
     */
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * Gets the id of this Recipe
     * @return Id of this Recipe 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this Recipe object.
     * @param id Id of this Recipe.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of this Recipe
     * @return name of this Recipe 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this Recipe object.
     * @param name Name of this Recipe.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this Recipe
     * @return Description of this Recipe 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for this Recipe object.
     * @param description Description of this Recipe.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Cuisine of this Recipe
     * @return Cuisine of this Recipe 
     */
    public Cuisine getCuisine() {
        return cuisine;
    }

    /**
     * Sets the Cuisine for this Recipe object.
     * @param cuisine Cuisine of this Recipe.
     */
    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    /**
     * Gets the prepping time of this Recipe
     * @return Prepping time of this Recipe 
     */
    public Duration getPrepTime() {
        return prepTime;
    }

    /**
     * Sets the prepping time for this Recipe object.
     * @param prepTime Prepping time of this Recipe.
     */
    public void setPrepTime(Duration prepTime) {
        this.prepTime = prepTime;
    }

    /**
     * Gets the cooking time of this Recipe
     * @return Cook time of this Recipe 
     */
    public Duration getCookTime() {
        return cookTime;
    }

    /**
     * Sets the cooking time for this Recipe object.
     * @param cookTime Cook time of this Recipe.
     */
    public void setCookTime(Duration cookTime) {
        this.cookTime = cookTime;
    }

    /**
     * Gets the Ingredients of this Recipe
     * @return Ingredients of this Recipe 
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the Ingredients for this Recipe object.
     * @param ingredients Ingredients of this Recipe.
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets the RecipeSteps of this Recipe
     * @return User of this Recipe 
     */
    public List<RecipeStep> getSteps() {
        return steps;
    }

    /**
     * Sets the RecipeSteps for this Recipe object.
     * @param steps RecipeSteps of this Recipe.
     */
    public void setSteps(List<RecipeStep> steps) {
        this.steps = steps;
    }

    /**
     * Gets the User of this Recipe
     * @return User of this Recipe 
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the User for this Recipe object.
     * @param user User of this Recipe.
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    public boolean getPub(boolean pub){
    	return pub;
    }
    
    public void setPub(boolean pub){
    	this.pub = pub;
    }

    /**
     * Add a RecipeStep object to put into Recipe
     * @param rs RecipeStep to be put into Recipe
     */
    public void addStep(RecipeStep rs) {
        rs.setRecipe(this);
        this.steps.add(rs);
    }

    /**
     * Add an Ingredient to the current Recipe
     * @param ing ingredient to be put into Recipe
     */
    public void addIngredient(Ingredient ing) {
        ing.setRecipe(this);
        this.ingredients.add(ing);
    }

}
