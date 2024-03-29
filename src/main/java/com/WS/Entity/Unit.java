/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import javax.persistence.*;

/**
 * Class representing a Unit object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "units")
public class Unit {

	/**
	 * Id of the Unit
	 */
    @Id
    @Column(name = "unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of the Unit
     */
    @Column(name = "unit_name")
    private String name;

    /**
     * Representation of a Recipe object in database.
     */
    public Unit() {
    }

    /**
     * Representation of a Unit object in database with a given name.
     * @param name Name to be assigned to Unit object
     */
    public Unit(String name) {
        this.name = name;
    }

    /**
     * Gets the id of this Unit.
     * @return Id of this Unit
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id for this Unit object.
     * @param id Id of this Unit.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of this Unit.
     * @return Name of this Unit
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this Unit object.
     * @param name Name of this Unit.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Returns a string representation of this Unit object.
     * @return String representation of this Unit object. 
     */
    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this Unit object.
     * @param o object being tested for equality with this Unit.
     * @return return true if obj and this Unit are equivalent.  False if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (id != unit.id) return false;
        return name != null ? name.equals(unit.name) : unit.name == null;
    }

    /**
     * Returns a hash code value for this Unit object.
     * @return integer that is the hash code for this Unit object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
