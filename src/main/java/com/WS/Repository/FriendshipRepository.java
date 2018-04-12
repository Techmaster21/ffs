package com.WS.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.WS.Entity.Friendship;
import com.WS.Entity.Recipe;
import com.WS.Entity.User;

public interface FriendshipRepository extends CrudRepository<Friendship, Integer> {
	public List<Friendship> findByUser(User user);
}