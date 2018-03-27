/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
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
@Table(name = "pantry_items")
public class PantryItem {
    @Id
    @Column(name = "pantry_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "NDB_No", nullable = false)
    private Food food;
    
    @OneToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
    
    @Column(name = "quantity")
    private double quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pantry_id", nullable = false)
    @JsonBackReference
    private Pantry pantry;

    public PantryItem(int id, Food food, Unit unit, double quantity, Pantry pantry) {
        this.id = id;
        this.food = food;
        this.unit = unit;
        this.quantity = quantity;
        this.pantry = pantry;
    }

    public PantryItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final PantryItem other = (PantryItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

    
    
}
