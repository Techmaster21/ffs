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
    
    private String unitName;

    public ClientUnit() {
    }
           
    public ClientUnit(Unit unit) {
        this.unitName = unit.getUnitName();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    
}
