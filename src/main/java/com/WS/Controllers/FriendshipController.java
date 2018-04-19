package com.WS.Controllers;

import com.WS.Entity.Friendship;
import com.WS.Entity.User;
import com.WS.Repository.FriendshipRepository;
import com.WS.Service.SecurityContextService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/friendship")
public class FriendshipController {

    private final Logger logger = LoggerFactory.getLogger(IngredientController.class);
    private final FriendshipRepository friendshipRepository;
    private final SecurityContextService securityContext;

    @Autowired
    public FriendshipController(FriendshipRepository friendshipRepository, SecurityContextService securityContext){
    	this.friendshipRepository = friendshipRepository; 
    	this.securityContext = securityContext;
    }
    
    
    @RequestMapping("/requestFriend")
    public void requestFriend(@RequestBody User user){
    	Friendship f = new Friendship();
    	f.setUser(securityContext.currentUser().get());
    	f.setFriend(user);
    	f.setRequest(true);
    	friendshipRepository.save(f);
    }
    
    @RequestMapping("/getFriendRequests")
    public List<User> getFriendRequests(){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendshipRequests = friendshipRepository.findByFriend(currentUser);
    	for(int i = 0; i < friendshipRequests.size(); i++) {
    		if(!friendshipRequests.get(i).isRequest()){
    			friendshipRequests.remove(i);
    		}
    	}
    	
    	List<User> usersRequesting = new ArrayList<>();
		for (Friendship friendshipRequest : friendshipRequests) {
			usersRequesting.add(friendshipRequest.getUser());
		}
    	
    	return usersRequesting;
    }
    
    @RequestMapping("/acceptFriendRequest")
    public void acceptFriendRequest(@RequestBody User user){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendshipRequests = friendshipRepository.findByFriend(currentUser);
		for (Friendship f : friendshipRequests) {
			if (f.getUser().equals(user)) {
				friendshipRepository.delete(f);
				f.setRequest(false);
				friendshipRepository.save(f);

				Friendship g = new Friendship(currentUser, user, false);
				friendshipRepository.save(g);
			}
		}
    }
    
    @RequestMapping("/declineFriendRequest")
    public void  declineFriendRequest(@RequestBody User user){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendshipRequests = friendshipRepository.findByFriend(currentUser);
		for (Friendship f : friendshipRequests) {
			if (f.getUser().equals(user)) {
				friendshipRepository.delete(f);
			}
		}
    }
    
    @RequestMapping("/getFriends")
    public List<User> getFriends(){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendships = friendshipRepository.findByUser(currentUser);
    	List<User> friends = new ArrayList<>();
		for (Friendship f : friendships) {
			if (!f.isRequest()) {
				friends.add(f.getFriend());
			}
		}
    	return friends;
    }
    
    @RequestMapping("/deleteFriend")
    public void deleteFriend(@RequestBody User user){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendships = friendshipRepository.findByFriend(user);
		for (Friendship f : friendships) {
			if (f.getUser().equals(currentUser)) {
				friendshipRepository.delete(f);
			}
		}
    	
    	List<Friendship> friendships2 = friendshipRepository.findByUser(user);
		for (Friendship f : friendships2) {
			if (f.getFriend().equals(currentUser)) {
				friendshipRepository.delete(f);
			}
		}
    }
 }
