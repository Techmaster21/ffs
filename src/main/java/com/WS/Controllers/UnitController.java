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

@Component
@RestController
@RequestMapping("/api/unit")
public class UnitController {

    private final Logger logger = LoggerFactory.getLogger(UnitController.class);
    @Autowired
    private UnitRepository unitRepository;

    public UnitController() {
    }

    @RequestMapping("/getAll")
    public List<Unit> getAllUnits() {
        List<Unit> units = (List<Unit>) unitRepository.findAll();
        return units;
    }

    @RequestMapping("/get")
    public Unit getUnit(@RequestBody Integer id) {
        return unitRepository.findById(id).get();
    }

    @RequestMapping("/save")
    public Unit saveUnit(@RequestBody Unit data) {
        return unitRepository.save(data);
    }

    @RequestMapping("/delete")
    public void deleteUnit(@RequestBody Integer id) {
        unitRepository.deleteById(id);
        // TODO should probably return something
    }

}
