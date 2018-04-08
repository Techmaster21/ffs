/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import javax.persistence.*;

/**
 * Class representing a Cuisine object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "cuisines")
public class Cuisine {

	/**
	 * Database id for Cuisine object.
	 */
    @Id
    @Column(name = "cuisine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of Cuisine object
     */
    @Column(name = "cuisine_name")
    private String name;

    /**
     * Representation of a Cuisine object in database with given name. 
     * @param name String used to name Cuisine object.
     */
    public Cuisine(String name) {
        this.name = name;
    }

    /**
     * Representation of a Cuisine object in the database.
     */
    public Cuisine() {
    }

    /**
     * Gets the id for this Cuisine.
     * @return this Cuisine's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this Cuisine.
     * @param id int to be used for this Cuisine's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name for this Cuisine.
     * @return String object for name of this Cuisine.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this Cuisine.
     * @param name String to be used for this Cuisine's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a hash code value for this Cuisine object.
     * @return integer that is the hash code for this Cuisine object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    /**
     * Returns a string representation of this Cuisine object.
     * @return String representation of this Cuisine object. 
     */
    @Override
    public String toString() {
        return "Cuisine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    
    /**
     * Indicates whether some other object is "equal to" this Cuisine object.
     * @param obj object being tested for equality with this Cuisine.
     * @return return true if obj and this Cuisine are equivalent.  False if not. 
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
        final Cuisine other = (Cuisine) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


}
