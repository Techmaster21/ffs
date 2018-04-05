package com.WS.Repository;

import com.WS.Entity.Cuisine;
import org.springframework.data.repository.CrudRepository;

public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {
}
