/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Cuisine;
import com.WS.Repository.CuisineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the Cuisine table.
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/cuisine")
public class CuisineController {

    private final Logger logger = LoggerFactory.getLogger(CuisineController.class);
            
    /**
     * Repository handling Cusines table.
     */
    private final CuisineRepository cuisineRepository;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the Cuisine table.
     *
     * @param cuisineRepository Repository handing Cuisines table.
     */
    @Autowired
    public CuisineController(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }
    /**
     * HTTP request for all Cuisines to make a finite list to choose from.
     * @return all Cuisines in the database. 
     */
    @RequestMapping("/getAll")
    public List<Cuisine> getAllCuisines() {
        List<Cuisine> cuisines = (List<Cuisine>) cuisineRepository.findAll();
        return cuisines;
    }
    

    /**
     * HTTP request for a Cuisine using a given id.
     * @param id The id used to get a specific cuisine
     * @return The cuisine requested.
     */
    @RequestMapping("/get")
    public Cuisine getCuisine(@RequestBody Integer id) {
        return cuisineRepository.findById(id).get();
    }
    
}

