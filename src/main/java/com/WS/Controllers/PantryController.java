/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Pantry;
import com.WS.Repository.PantryRepository;
import com.WS.Entity.User;
import com.WS.Repository.PantryRepository;
import com.WS.Service.SecurityContextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/pantry")
public class PantryController {
    private final Logger logger = LoggerFactory.getLogger(PantryController.class);
    private final PantryRepository pantryRepository;
    private final SecurityContextService securityContext;

    @Autowired
    public PantryController(PantryRepository pantryRepository, SecurityContextService securityContext) {
        this.pantryRepository = pantryRepository;
        this.securityContext = securityContext;
    }

    @RequestMapping("/get")
    public Pantry getPantry() {
        User currentUser = securityContext.currentUser().get();
        Pantry currentUserPantry = pantryRepository.findByUser(currentUser);
        if (currentUserPantry == null) {
            // create new empty pantry
            Pantry newPantry = new Pantry(currentUser);
            pantryRepository.save(newPantry);
            return newPantry;
        }
        return pantryRepository.findByUser(currentUser);
    }
    
    @RequestMapping("/save")
    public void savePantry(@RequestBody Pantry pantry) {
        User currentUser = securityContext.currentUser().get();
        pantry.setUser(currentUser);
        pantryRepository.deleteByUser(currentUser);
        pantryRepository.save(pantry);
    }

}
