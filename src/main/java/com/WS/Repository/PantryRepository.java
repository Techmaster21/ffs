/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Repository;

import com.WS.Entity.Ffser;
import com.WS.Entity.Pantry;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Eric
 */
public interface PantryRepository extends CrudRepository<Pantry, Integer> {
    
    public Pantry findByFfser(Ffser ffser);
    
}
