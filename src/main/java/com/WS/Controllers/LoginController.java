/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ffser;
import com.WS.Repository.FfserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eric
 */
@RestController
@RequestMapping(path = "/api/account")
public class LoginController {
    @Value("${SECRET}")
    private String secret;
    
    
    @Autowired
    FfserRepository ffserRepository;
    @PostMapping("/login")
    public String login(Ffser ffser){
        Ffser ffserWithName = ffserRepository.findByUsername(ffser.getUsername());
        if (ffserWithName != null && ffserWithName.getPassword().equals(ffser.getPassword())){ 
                return Jwts.builder()
                .setSubject(ffser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        }
        return "";
    }
    
    @PostMapping("/signUp")
    public boolean signUp(@RequestBody Ffser ffser){
        Ffser ffserWithName = ffserRepository.findByUsername(ffser.getUsername());
        if (ffserWithName == null) {
            ffserRepository.save(ffser);
            return true;
        }
        return false;
        
    }
}
