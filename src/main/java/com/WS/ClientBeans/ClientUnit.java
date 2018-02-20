/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Unit;

/**
 *
 * @author Eric
 */
public class ClientUnit {
    
    private String name;

    public ClientUnit() {
    }
           
    public ClientUnit(Unit unit) {
        this.name = unit.getUnitName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
