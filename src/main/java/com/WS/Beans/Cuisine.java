/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "cuisines")
public class Cuisine {
    
    @Id
    @Column(name = "cuisine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuisineId;
    
    @Column(name = "cuisine_name")
    private String cuisineName;

    public Cuisine() {
    }

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.cuisineId;
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
        final Cuisine other = (Cuisine) obj;
        if (this.cuisineId != other.cuisineId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuisine{" + "cuisineId=" + cuisineId + ", cuisineName=" + cuisineName + '}';
    }
    
    
}
