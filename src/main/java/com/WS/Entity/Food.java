/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import javax.persistence.*;

/**
 * Class representing a Food object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "food_des")
public class Food {

	/**
	 * Database id for Food object.
	 */
    @Id
    @Column(name = "NDB_No")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of Food object
     */
    @Column(name = "Long_Desc")
    private String name;

    /**
     * Representation of a Food object in database. 
     */
    public Food() {
    }

    /**
     * Representation of a Food object in database with given name. 
     * @param name String used to name Cuisine object.
     */
    public Food(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of this Food object.
     * @return String representation of this Food object. 
     */
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Gets the id for this Food.
     * @return this Food's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this Food.
     * @param id int to be used for this Food's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name for this Food.
     * @return String object for name of this Food.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this Food.
     * @param name String to be used for this Food's name.
     */
    public void setName(String name) {
        this.name = name;
    }


}
