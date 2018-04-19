/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Pantry;
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

/**
 * Controller that handles HTTP requests that require queries to the Pantry
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/pantry")
public class PantryController {
    private final Logger logger = LoggerFactory.getLogger(PantryController.class);
    private final PantryRepository pantryRepository;
    private final SecurityContextService securityContext;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the pantry table.
     *
     * @param pantryRepository Repository handing pantry table.
     */
    @Autowired
    public PantryController(PantryRepository pantryRepository, SecurityContextService securityContext) {
        this.pantryRepository = pantryRepository;
        this.securityContext = securityContext;
    }

     /**
     * HTTP request for getting the pantry for the user requesting it from the pantry table
     *
     * @return The user's pantry
     */
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
    
         /**
     * HTTP request for saving a user's pantry to the pantry table
     *
     * @param  pantry The pantry to be saved
     */
    @RequestMapping("/save")
    public void savePantry(@RequestBody Pantry pantry) {
        User currentUser = securityContext.currentUser().get();
        pantry.setUser(currentUser);
        pantryRepository.deleteByUser(currentUser);
        pantryRepository.save(pantry);
    }

}
