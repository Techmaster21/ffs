/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Class representing a Ingredient object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "ingredients")
public class Ingredient {

	/**
	 * Id of Ingredient in Database
	 */
    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Food that Ingredient is
     */
    @OneToOne
    @JoinColumn(name = "food_id", referencedColumnName = "NDB_No", nullable = false)
    private Food food;

    /**
     * Unit Ingredient is in. 
     */
    @OneToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    /**
     * Quantity of Ingredient   
     */
    @Column(name = "quantity")
    private double quantity;

    /**
     * Recipe that Ingredient is a part of. 
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonBackReference
    private Recipe recipe;

    /**
     * Representation of an Ingredient object in database.
     */
    public Ingredient() {
    }
    
    /**
     * Representation of an Ingredient object in database with given food, unit, quantity, recipe.. 
     * @param food Food object that represents Ingredient
     * @param unit Unit Ingredient is in
     * @param quantity Quantity of Ingredient
     * @param recipe Recipe Ingredient is a part of
     */
    public Ingredient(Food food, Unit unit, double quantity, Recipe recipe) {
        this.food = food;
        this.unit = unit;
        this.quantity = quantity;
        this.recipe = recipe;
    }

    /**
     * Gets the id of this Ingredient
     * @return id of this Ingredient 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of this Ingredient object.
     * @param id id of this Ingredient.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Food of this Ingredient
     * @return Food of this Ingredient 
     */
    public Food getFood() {
        return food;
    }

    /**
     * Sets the food of this Ingredient object.
     * @param food Food of this Ingredient.
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Gets the Unit of this Ingredient
     * @return Unit of this Ingredient 
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Sets the unit of this Ingredient object.
     * @param unit Unit of this Ingredient.
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Gets the quantity of this Ingredient
     * @return Quantity of this Ingredient 
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this Ingredient object.
     * @param quantity Recipe of this Ingredient.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the Recipe of this Ingredient
     * @return Recipe of this Ingredient 
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets the Recipe for this Ingredient object.
     * @param recipe Recipe to be used for this Ingredient.
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Returns a string representation of this Ingredient object.
     * @return String representation of this Ingredient object. 
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", food=" + food +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", recipe=" + recipe +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this Ingredient object.
     * @param o object being tested for equality with this Ingredient.
     * @return return true if obj and this Ingredient are equivalent.  False if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (food != null ? !food.equals(that.food) : that.food != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        return recipe != null ? recipe.equals(that.recipe) : that.recipe == null;
    }

    /**
     * Returns a hash code value for this Ingredient object.
     * @return integer that is the hash code for this Ingredient object
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        return result;
    }
}
