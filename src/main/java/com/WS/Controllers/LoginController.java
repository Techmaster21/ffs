/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Ffser;
import com.WS.Entity.Permission;
import com.WS.Repository.FfserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eric
 */
@Component
@RestController
@RequestMapping(path = "/api/account")
public class LoginController {
    @Value("${SECRET}")
    private String secret;
    
    @Autowired
    private FfserRepository ffserRepository;

    @PostMapping("/login")
    public Token login(@RequestBody Ffser ffser) throws UnsupportedEncodingException {
        Ffser ffserWithName = ffserRepository.findByUsername(ffser.getUsername());
        if (ffserWithName != null && ffserWithName.getPassword().equals(ffser.getPassword())){
                Date expiration = new Date(System.currentTimeMillis() + 3600000);
                String text = Jwts.builder()
                        .setSubject(ffser.getUsername())
                        .setExpiration(expiration)
                        .signWith(SignatureAlgorithm.HS512, secret.getBytes("UTF-8"))
                        .compact();
                return new Token(text, expiration);
        }
        return null;
    }
    
    @PostMapping("/signup")
    public boolean signUp(@RequestBody Ffser ffser){
        Permission p = new Permission();
        p.setId(2);
        p.setTitle("basic");
        ffser.setPermission(p);
        Ffser ffserWithName = ffserRepository.findByUsername(ffser.getUsername());
        if (ffserWithName == null) {
            ffserRepository.save(ffser);
            return true;
        }
        return false;
        
    }
    
    public Ffser getFfser(String token){
        return ffserRepository.findByUsername(
                            Jwts.parser()
                            .setSigningKey(secret.getBytes())
                            .parseClaimsJws(token)
                            .getBody()
                            .getSubject());
    }
}
