package com.WS.Repository;

import com.WS.Entity.Event;
import com.WS.Entity.Recipe;
import com.WS.Entity.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer>{
	List<Event> findByUser(User user);
	List<Event> findByRecipe(Recipe recipe);
}
