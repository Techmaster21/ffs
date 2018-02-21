package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Cuisine;

public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {

}
