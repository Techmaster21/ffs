/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Friendship;
import com.WS.Entity.User;
import com.WS.Repository.FriendshipRepository;
import com.WS.Repository.UserRepository;
import com.WS.Service.SecurityContextService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the FFSer
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final SecurityContextService securityContext;

    
    /**
     * Repository handling ffser table.
     */
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the ffser table.
     *
     * @param userRepository Repository handing ffser table.
     */
    @Autowired
    public UserController(UserRepository userRepository, FriendshipRepository friendshipRepository, SecurityContextService securityContext) {
        this.userRepository = userRepository;
        this.securityContext = securityContext;
        this.friendshipRepository = friendshipRepository;
    }

    /**
     * HTTP request for getting a specific recipe from the Recipes table
     *
     * @param s The string to search the Users table by
     * @return A list of users with similar names to the search
     */
    @RequestMapping("/searchByName")
    public List<User> searchByName(@RequestBody String s) {
    	User currentUser = securityContext.currentUser().get();
        List<User> users = userRepository.findByUsernameContaining(s);
        users.remove(currentUser);
        return users;
    }
    
    @RequestMapping("/searchWithoutFriends")
    public List<User> searchWithoutFriends(@RequestBody String s) {
    	User currentUser = securityContext.currentUser().get();
    	List<User> users = userRepository.findByUsernameContaining(s);
    	List<Friendship> friendships = friendshipRepository.findByUser(currentUser);

    	users.remove(currentUser);
        for (Friendship friendship : friendships) {
            users.remove(friendship.getFriend());
        }
    	return users;
    }
}
