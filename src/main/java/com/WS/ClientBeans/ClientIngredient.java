/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Food;
import com.WS.Beans.Ingredient;

/**
 *
 * @author Eric
 */
public class ClientIngredient {
    private ClientFood food;
    private ClientUnit unit;
    private double quantity;

    public ClientIngredient() {
    }
    
    public ClientIngredient(ClientFood food, ClientUnit unit, double quantity) {
        this.food = food;
        this.unit = unit;
        this.quantity = quantity;
    }

    public ClientIngredient (Ingredient ingredient){
        this.food = new ClientFood(ingredient.getFood());
        this.unit = new ClientUnit(ingredient.getUnit());
        this.quantity = ingredient.getQuantity();
    }

    public ClientFood getFood() {
        return food;
    }

    public void setFood(ClientFood food) {
        this.food = food;
    }

    public ClientUnit getUnit() {
        return unit;
    }

    public void setUnit(ClientUnit unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    
}
