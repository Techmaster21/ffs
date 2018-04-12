package com.WS.Controllers;

import com.WS.Entity.Friendship;
import com.WS.Entity.Ingredient;
import com.WS.Entity.User;
import com.WS.Repository.FriendshipRepository;
import com.WS.Repository.IngredientRepository;
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
    	for(int i = 0; i < friendshipRequests.size(); i++){
    		if(!friendshipRequests.get(i).isRequest()){
    			friendshipRequests.remove(i);
    		}
    	}
    	
    	List<User> usersRequesting = new ArrayList<User>();
    	for(int i = 0; i < friendshipRequests.size(); i++){
    		usersRequesting.add(friendshipRequests.get(i).getUser());
    	}
    	
    	return usersRequesting;
    }
    
    @RequestMapping("/acceptFriendRequest")
    public void acceptFriendRequest(@RequestBody User user){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendshipRequests = friendshipRepository.findByFriend(currentUser);
    	for(int i = 0; i < friendshipRequests.size(); i++){
    		Friendship f = friendshipRequests.get(i);
    		if(f.getUser().equals(user)){
    			friendshipRepository.delete(f);
    			f.setRequest(false);
    			friendshipRepository.save(f);
    		}
    	}
    }
    
    @RequestMapping("/declineFriendRequest")
    public void  declineFriendRequest(@RequestBody User user){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendshipRequests = friendshipRepository.findByFriend(currentUser);
    	for(int i = 0; i < friendshipRequests.size(); i++){
    		Friendship f = friendshipRequests.get(i);
    		if(f.getUser().equals(user)){
    			friendshipRepository.delete(f);
    		}
    	}
    }
    
    @RequestMapping("/getFriends")
    public List<User> getFriends(){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendships = friendshipRepository.findByUser(currentUser);
    	List<User> friends = new ArrayList<User>();
    	for(int i = 0; i < friendships.size(); i++){
    		Friendship f = friendships.get(i);
    		if(!f.isRequest()){
    			friends.add(f.getFriend());
    		}
    	}
    	return friends;
    }
    
    @RequestMapping("/deleteFriend")
    public void deleteFriend(User user){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendships = friendshipRepository.findByFriend(user);
    	for(int i = 0; i < friendships.size(); i++){
    		Friendship f = friendships.get(i);
    		if(f.getUser().equals(currentUser)){
    			friendshipRepository.delete(f);
    		}
    	}
    }
    
    
    
    //Fix search to not have current user and already added friends
}
