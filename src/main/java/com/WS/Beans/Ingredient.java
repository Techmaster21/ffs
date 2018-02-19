/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @OneToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;
    
    @OneToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
    
    @Column(name = "quantity")
    private double quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    

    public Ingredient() {
    }

    public Ingredient(int ingredientId, Food food, Unit unit, double quantity, Recipe recipe) {
        this.ingredientId = ingredientId;
        this.food = food;
        this.unit = unit;
        this.quantity = quantity;
        this.recipe = recipe;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.ingredientId;
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
        final Ingredient other = (Ingredient) obj;
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "ingredientId=" + ingredientId + ", food=" + food + '}';
    }
    
}
