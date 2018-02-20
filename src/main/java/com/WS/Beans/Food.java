/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Beans;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.WS.ClientBeans.ClientFood;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "foods")
public class Food {
    
    @Id
    @Column(name = "food_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;
    
    @Column(name = "food_name")
    private String foodName;

    public Food() {
    }
    
    public Food(ClientFood food){
    	this.foodName = food.getName();
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.foodId;
        hash = 97 * hash + Objects.hashCode(this.foodName);
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
        final Food other = (Food) obj;
        if (this.foodId != other.foodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Food{" + "foodId=" + foodId + ", foodName=" + foodName + '}';
    }
    
    
}
