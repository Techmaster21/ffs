/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Food;

/**
 *
 * @author Eric
 */
public class ClientFood {
    
    private String foodName;

    public ClientFood(String foodName) {
        this.foodName = foodName;
    }

    public static ClientFood fromFood(Food food){
        return new ClientFood(food.getFoodName());
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    
    
    
}
