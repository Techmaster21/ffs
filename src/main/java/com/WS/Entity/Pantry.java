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
import java.util.Objects;

/**
 * Class representing a Pantry object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "pantry")
public class Pantry {

	/**
	 * Id number for this Pantry
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pantry_id")
    private int id;

    /**
     * User assigned to this pantry
     */
    @OneToOne
    @JoinColumn(name = "ffser_id")
    private User user;

    /**
     * Items assigned to this Pantry
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pantry")
    @JsonManagedReference
    private List<PantryItem> items = new ArrayList<>();

    /**
     * Representation of an Pantry object in database with given user.
     */
    public Pantry() {
    }

    /**
     * Representation of an Pantry object in database with given user.
     * @param user Given user to be assigned to Pantry
     */
    public Pantry(User user) {
        this.user = user;
    }


    /**
     * Representation of an Pantry object in database with given user and items.
     * @param user Given user to be assigned to Pantry
     * @param items Given items to assign to Pantry
     */
    public Pantry(User user, List<PantryItem> items) {
        this.user = user;
        this.items = items;
    }

    /**
     * Gets the id of this Pantry.
     * @return Id of Pantry object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of this Pantry object.
     * @param id Id of the Pantry.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the User of this Pantry
     * @return User Pantry belongs to.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of this Pantry object.
     * @param user User Pantry belongs to.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the Items of this Pantry
     * @return Items of this Pantry 
     */
    public List<PantryItem> getItems() {
        return items;
    }

    /**
     * Sets the items of this Pantry object.
     * @param items items of this Pantry
     */
    public void setItems(List<PantryItem> items) {
        this.items = items;
    }

    /**
     * Returns a hash code value for this Pantry object.
     * @return integer that is the hash code for this Pantry object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    /**
     * Indicates whether some other object is "equal to" this Pantry object.
     * @param obj object being tested for equality with this Pantry.
     * @return return true if obj and this Pantry are equivalent.  False if not. 
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
        final Pantry other = (Pantry) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }


    /**
     * Returns a string representation of this Pantry object.
     * @return String representation of this Pantry object. 
     */
    @Override
    public String toString() {
        return "Pantry{" +
                "id=" + id +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
