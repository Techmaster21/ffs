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

    public static ClientFfser fromFfser(Ffser ffser){
        return new ClientFfser(ffser.getUsername());
    } 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
            
    
         
}
