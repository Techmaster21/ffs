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

@Component
@RestController
@RequestMapping("/api/users")
public class CuisineController {

    private final Logger logger = LoggerFactory.getLogger(CuisineController.class);
    @Autowired
    private CuisineRepository cuisineRepository;

    public CuisineController() {
    }

    @RequestMapping("/getAllCuisines")
    public List<Cuisine> getAllCuisines() {
        List<Cuisine> cuisines = (List<Cuisine>) cuisineRepository.findAll();
        return cuisines;
    }

    @RequestMapping("/getCuisine")
    public Cuisine getCuisine(@RequestBody Integer id) {
        return cuisineRepository.findById(id).get();
    }

    @RequestMapping("/deleteCuisine")
    public void deleteCuisine(@RequestBody Integer id) {
        cuisineRepository.deleteById(id);
        // TODO should probably return something
    }

    @RequestMapping("/saveCuisine")
    public void saveCuisine(@RequestBody Cuisine data) {
        cuisineRepository.save(data);
        // TODO should probably return something
    }
}

