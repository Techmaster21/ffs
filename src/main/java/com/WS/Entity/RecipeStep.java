/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Class representing a RecipeStep object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "recipe_steps")
public class RecipeStep {

	/**
	 * Id of the RecipeStep
	 */
    @Id
    @Column(name = "step_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Description of the RecipeStep
     */
    @Column(name = "step")
    private String step;

    /**
     * Recipe that this RecipeStep belongs to.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonBackReference
    private Recipe recipe;

    /**
     * Representation of a Recipe object in database.
     */
    public RecipeStep() {
    }

    /**
     * Representation of a Recipe object in database with given step description and recipe.
     * @param step
     * @param recipe
     */
    public RecipeStep(String step, Recipe recipe) {
        this.step = step;
        this.recipe = recipe;
    }

    /**
     * Returns a hash code value for this RecipeStep object.
     * @return integer that is the hash code for this RecipeStep object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    /**
     * Indicates whether some other object is "equal to" this RecipeStep object.
     * @param obj object being tested for equality with this RecipeStep.
     * @return return true if obj and this RecipeStep are equivalent.  False if not. 
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
        final RecipeStep other = (RecipeStep) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * Gets the id of this RecipeStep.
     * @return Id of this RecipeStep
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this RecipeStep object.
     * @param id Id for this RecipeStep.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the description of this RecipeStep.
     * @return Description of this RecipeStep
     */
    public String getStep() {
        return step;
    }

    /**
     * Sets the description for this RecipeStep object.
     * @param step String description of this RecipeStep.
     */
    public void setStep(String step) {
        this.step = step;
    }

    /**
     * Gets the Recipe of this RecipeStep.
     * @return Recipe of this RecipeStep
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets the Recipe for this RecipeStep object.
     * @param recipe Recipe of this RecipeStep.
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    
    /**
     * Returns a string representation of this RecipeStep object.
     * @return String representation of this RecipeStep object. 
     */
    @Override
    public String toString() {
        return "RecipeStep{" +
                "id=" + id +
                ", step='" + step + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
