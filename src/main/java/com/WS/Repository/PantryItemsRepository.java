/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Repository;

import com.WS.Entity.PantryItem;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Eric
 */
public interface PantryItemsRepository extends CrudRepository<PantryItem, Integer>{
    
}
