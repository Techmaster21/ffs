package com.WS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Ffser;

public interface FfserRepository extends CrudRepository<Ffser, Integer>{

    public Ffser findByUsername(String username);
}
