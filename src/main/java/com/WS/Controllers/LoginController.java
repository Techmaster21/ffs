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
import org.springframework.web.bind.annotation.RequestMethod;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Eric
 */
@RequestMapping("/api/account")
public class LoginController {
    @Value("${SECRET}")
    private String secret;
    
    
    @Autowired
    FfserRepository ffserRepository;
    @RequestMapping(name = "/login", method = RequestMethod.POST)
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
    
    @RequestMapping(name = "/singUp", method = RequestMethod.POST)
    public boolean signUp(Ffser ffser){
        Ffser ffserWithName = ffserRepository.findByUsername(ffser.getUsername());
        if (ffserWithName == null) {
            ffserRepository.save(ffser);
            return true;
        }
        return false;
        
    }
}
