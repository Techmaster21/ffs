/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Ingredient;

/**
 *
 * @author Eric
 */
public class ClientIngredient {
    private String foodName;
    private String unitName;
    private double quantity;

    public ClientIngredient(String foodName, String unitName, double quantity) {
        this.foodName = foodName;
        this.unitName = unitName;
        this.quantity = quantity;
    }
    
    public static ClientIngredient fromIngredient(Ingredient ingredient){
        return new ClientIngredient(ingredient.getFood().getFoodName(),ingredient.getUnit().getUnitName(), ingredient.getQuantity());
    }
    
}
