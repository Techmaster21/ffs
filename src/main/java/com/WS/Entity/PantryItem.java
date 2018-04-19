/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Class representing a PantryItem object in the database with proper links to it.
 * @author YT_6
 *
 */
@Entity
@Table(name = "pantry_items")
public class PantryItem {
	/**
	 * Integer that is the id for the PantryItem
	 */
    @Id
    @Column(name = "pantry_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Food PantryItem is representing
     */
    @OneToOne()
    @JoinColumn(name = "food_id", referencedColumnName = "NDB_No", nullable = false)
    private Food food;

    /**
     * Unit PantryItem is in
     */
    @OneToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    /**
     * Quantity of PantryItem
     */
    @Column(name = "quantity")
    private double quantity;

    /**
     * Pantry object assigned to PantryItem
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pantry_id", nullable = false)
    @JsonBackReference
    private Pantry pantry;

    /**
     *Representation of a PantryItem object in database.
     * 
     */
    public PantryItem() {
    }

    /**
     * Representation of a PantryItem object in database with given food, unit, quantity and pantry.
     * @param food
     * @param unit
     * @param quantity
     * @param pantry
     */
    public PantryItem(Food food, Unit unit, double quantity, Pantry pantry) {
        this.food = food;
        this.unit = unit;
        this.quantity = quantity;
        this.pantry = pantry;
    }

    /**
     * Gets the id of this PantryItem
     * @return Id of this PantryItem 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of this PantryItem object.
     * @param id Id of this PantryItem.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the food represented by this PantryItem
     * @return Food represented by this PantryItem 
     */
    public Food getFood() {
        return food;
    }

    /**
     * Sets the Food represented by this PantryItem object.
     * @param food Food representing this PantryItem.
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Gets the unit of this PantryItem
     * @return Unit of this PantryItem 
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Sets the unit of this PantryItem object.
     * @param unit Unit of this PantryItem.
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Gets the quantity of this PantryItem
     * @return Quantity of this PantryItem 
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this PantryItem object.
     * @param quantity Quantity of this PantryItem.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the Pantry object of this PantryItem
     * @return Pantry of this PantryItem 
     */
    public Pantry getPantry() {
        return pantry;
    }

    /**
     * Sets the Pantry of this PantryItem object.
     * @param pantry Pantry of this PantryItem.
     */
    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    /**
     * Returns a string representation of this PantryItem object.
     * @return String representation of this PantryItem object. 
     */
    @Override
    public String toString() {
        return "PantryItem{" +
                "id=" + id +
                ", food=" + food +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", pantry=" + pantry.getId() +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this PantryItem object.
     * @param o object being tested for equality with this PantryItem.
     * @return return true if obj and this PantryItem are equivalent.  False if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PantryItem that = (PantryItem) o;

        if (id != that.id) return false;
        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (food != null ? !food.equals(that.food) : that.food != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        return pantry != null ? pantry.equals(that.pantry) : that.pantry == null;
    }

    /**
     * Returns a hash code value for this PantryItem object.
     * @return integer that is the hash code for this PantryItem object
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
        result = 31 * result + (pantry != null ? pantry.hashCode() : 0);
        return result;
    }
}
