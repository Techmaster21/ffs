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
    
    private String name;

    public ClientFood(String foodName) {
        this.name = foodName;
    }
    
    public ClientFood(Food food){
        this.name = food.getFoodName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
