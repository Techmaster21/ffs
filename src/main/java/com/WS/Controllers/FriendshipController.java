package com.WS.Controllers;

import com.WS.Entity.Ingredient;
import com.WS.Repository.FriendshipRepository;
import com.WS.Repository.IngredientRepository;
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
//    private final FriendshipRepository friendshipRepository;
	
}
