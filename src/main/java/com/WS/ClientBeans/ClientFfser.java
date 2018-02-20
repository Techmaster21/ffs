/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.ClientBeans;

import com.WS.Beans.Ffser;

/**
 *
 * @author Eric
 */
public class ClientFfser {
    
    private String username;

    public ClientFfser(String username) {
        this.username = username;
    }

    public ClientFfser (Ffser ffser){
        this.username = ffser.getUsername();
    } 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
            
    
         
}
