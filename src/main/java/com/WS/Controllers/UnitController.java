/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Unit;
import com.WS.Repository.UnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the Units
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/unit")
public class UnitController {

    private final Logger logger = LoggerFactory.getLogger(UnitController.class);
    private final UnitRepository unitRepository;
    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the Units table.
     *
     * @param unitRepository Repository handing Units table.
     */
    @Autowired
    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    /**
     * HTTP request for getting all of the Units from the Units table
     *
     * @return All of the Units in the Units table
     */
    @RequestMapping("/getAll")
    public List<Unit> getAllUnits() {
        List<Unit> units = (List<Unit>) unitRepository.findAll();
        return units;
    }

    /**
     * HTTP request for getting a specific unit from the Units table
     *
     * @param id The id of the unit to return
     * @return The unit with the requested id
     */
    @RequestMapping("/get")
    public Unit getUnit(@RequestBody Integer id) {
        return unitRepository.findById(id).get();
    }

}
