/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private int id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "recipe_description")
    private String description;

    @OneToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @Column(name = "prep_time")
    private String prepTime;

    @Column(name = "cook_time")
    private String cookTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recipe")
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recipe")
    @JsonManagedReference
    private List<RecipeStep> steps = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User user;

    public Recipe() {
    }

    public Recipe(String name, String description, Cuisine cuisine, String prepTime, String cookTime,
                  List<Ingredient> ingredients, List<RecipeStep> steps, User user) {
        this.name = name;
        this.description = description;
        this.cuisine = cuisine;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.steps = steps;
        this.user = user;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RecipeStep> steps) {
        this.steps = steps;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addStep(RecipeStep rs) {
        rs.setRecipe(this);
        this.steps.add(rs);
    }

    public void addIngredient(Ingredient ing) {
        ing.setRecipe(this);
        this.ingredients.add(ing);
    }

}
