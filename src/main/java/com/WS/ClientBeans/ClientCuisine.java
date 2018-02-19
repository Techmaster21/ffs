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
    
    String cuisineName;

    public ClientCuisine(String cuisineName) {
        this.cuisineName = cuisineName;
    }
    
    public static ClientCuisine fromCuisine(Cuisine cuisine){
        return new ClientCuisine(cuisine.getCuisineName());
    }
}
