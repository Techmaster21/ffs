/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Pantry;
import com.WS.Repository.PantryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/users")
public class PantryController {

    private final Logger logger = LoggerFactory.getLogger(PantryController.class);
    @Autowired
    LoginController loginController;
    @Autowired
    private PantryRepository pantryRepository;

    public PantryController() {
    }

    //TODO Maybe include token in headers and use to get user?
    @RequestMapping("/getPantry")
    public void getPantry() {
//        client.sendEvent("getPantry", pantryRepository.findByFfser(
//                loginController.getFfser(client.getHandshakeData().getSingleUrlParam("token"))));
    }

    @RequestMapping("/savePantry")
    public void updatePantry(@RequestBody Pantry pantry) {
//    	data.setFfser(loginController.getFfser(client.getHandshakeData().getSingleUrlParam("token")));
//    	pantryRepository.delete(data);
//    	pantryRepository.save(data);
    }

}
