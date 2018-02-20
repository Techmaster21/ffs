/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Cuisine;

/**
 *
 * @author Eric
 */
public class ClientCuisine {
    
    String name;

    public ClientCuisine(String cuisineName) {
        this.name = cuisineName;
    }
    
    public ClientCuisine (Cuisine cuisine){
        this.name = cuisine.getCuisineName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
