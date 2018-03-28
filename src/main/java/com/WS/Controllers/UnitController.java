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
@RequestMapping("/api/users")
public class UnitController {

    private final Logger logger = LoggerFactory.getLogger(UnitController.class);
    @Autowired
    private UnitRepository unitRepository;

    public UnitController() {
    }

    @RequestMapping("/getAllUnits")
    public List<Unit> getAllUnits() {
        List<Unit> units = (List<Unit>) unitRepository.findAll();
        return units;
    }

    @RequestMapping("/getUnit")
    public Unit getUnit(@RequestBody Integer id) {
        return unitRepository.findById(id).get();
    }

    @RequestMapping("/saveUnit")
    public void saveUnit(@RequestBody Unit data) {
        unitRepository.save(data);
        // TODO should probably return something
    }

    @RequestMapping("/deleteUnit")
    public void deleteUnit(@RequestBody Integer id) {
        unitRepository.deleteById(id);
        // TODO should probably return something
    }

}
