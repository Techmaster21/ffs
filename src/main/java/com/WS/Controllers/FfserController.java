/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ffser;
import com.WS.Repository.FfserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/ffser")
public class FfserController {

    private final Logger logger = LoggerFactory.getLogger(FfserController.class);
    @Autowired
    private FfserRepository ffserRepository;

    public FfserController() {
    }

    @RequestMapping("/save")
    public Ffser saveFfser(@RequestBody Ffser ffser) {
        return ffserRepository.save(ffser);
    }

    @RequestMapping("/delete")
    public void deleteFfser(@RequestBody Integer id) {
        ffserRepository.deleteById(id);
        // TODO should probably return something
    }


}
