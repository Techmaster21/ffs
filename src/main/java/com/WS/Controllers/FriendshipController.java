package com.WS.Controllers;

import com.WS.Entity.Friendship;
import com.WS.Entity.Ingredient;
import com.WS.Entity.User;
import com.WS.Repository.FriendshipRepository;
import com.WS.Repository.IngredientRepository;
import com.WS.Service.SecurityContextService;

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
    
    
    //TODO:Add Friend Request (requestFriend)
    //Get Friend Requests (getFriendRequests)
    //Accept Friend Requests (getFriendRequest)
    //Deny Friend Request (declineFriendRequest)
    
    @RequestMapping("/requestFriend")
    public void requestFriend(@RequestBody User user){
    	Friendship f = new Friendship();
    	f.setUser(securityContext.currentUser().get());
    	f.setFriend(user);
    	f.setRequest(true);
    	friendshipRepository.save(f);
    }
    
    @RequestMapping("/getFriendRequests")
    public List<Friendship> getFriendRequests(){
    	User currentUser = securityContext.currentUser().get();
    	List<Friendship> friendshipRequests = friendshipRepository.findByFriend(currentUser);
    	for(int i = 0; i < friendshipRequests.size(); i++){
    		if(!friendshipRequests.get(i).isRequest()){
    			friendshipRequests.remove(i);
    		}
    	}
    	return friendshipRequests;
    }
}
