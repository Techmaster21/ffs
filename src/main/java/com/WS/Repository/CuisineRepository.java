package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Cuisine;
import java.util.Optional;

public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {

    public Optional<Cuisine> findByName(String name);
}
