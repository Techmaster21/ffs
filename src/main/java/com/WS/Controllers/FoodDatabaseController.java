/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Food;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;





import com.WS.Repository.FoodRepository;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 *
 * @author Samuel
 */
@Component
public class FoodDatabaseController implements SocketIOController {
	
	@Autowired
	private FoodRepository foodRepository;

    private final SocketIOServer server;
    private final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    public FoodDatabaseController() {
        this.server = null;
    }

    @Autowired
    public FoodDatabaseController(SocketIOServer server) {
        this.server = server;
    }
    
    public String getNamespace() {
		return "/users";
    }


    @OnEvent(value = "getFoodItemsByName")
    public void getFoods(SocketIOClient client, AckRequest request, String data) {
        List<Food> foodMaster = foodRepository.findByNameContaining(data);
        List<Food> foods = new ArrayList<Food>(foodMaster);
        List<Food> foodsStartingWith = new ArrayList<Food>();
        List<Food> foodsWithStrictlyWord = new ArrayList<Food>();
        List<Food> foodsWithSingularWord = new ArrayList<Food>();
        int dataLength = data.length();
        for(Food h: foodMaster){
        	String fi = h.getName();
        	String foodItem = fi.toLowerCase();
            if(foodItem.indexOf(data) == 0){
            	if(foodItem.length() > dataLength){
            		char followingChar = foodItem.charAt(dataLength);
            		if(Character.isSpaceChar(followingChar) || followingChar == ','){
            			foodsWithStrictlyWord.add(h);
            			foods.remove(h);
            		}
            		else{
            			foodsStartingWith.add(h);
            			foods.remove(h);
            		}
            	}
            	else{
            		foodsWithStrictlyWord.add(h);
            		foods.remove(h);
            	}
            }
            else{
            	int ind = foodItem.indexOf(data);
            	if (ind != -1) {
                    if (!Character.isLetter(foodItem.charAt(ind - 1))) {
                        if (ind + dataLength < foodItem.length() && !Character.isLetter(foodItem.charAt(ind + dataLength))) {
                            foodsWithSingularWord.add(h);
                            foods.remove(h);
                        } else if (ind + dataLength == foodItem.length()) {
                            foodsWithSingularWord.add(h);
                            foods.remove(h);
                        }
                    }
                }
            }
        }
        foodDatabaseComparator fdc = new foodDatabaseComparator();
        ArrayList<Food> finalList = new ArrayList<Food>();
        java.util.Collections.sort(foods, fdc);
        java.util.Collections.sort(foodsStartingWith, fdc);
        java.util.Collections.sort(foodsWithStrictlyWord, fdc);
        java.util.Collections.sort(foodsWithSingularWord, fdc);
        finalList.addAll(foodsWithStrictlyWord);
        finalList.addAll(foodsStartingWith);
        finalList.addAll(foodsWithSingularWord);
        finalList.addAll(foods);
        for(Food e : finalList){
        	System.out.println(e.getName());
        }
    	client.sendEvent("getFoodItemsByName", finalList);
    }
    
    @OnEvent(value = "getAllFoodItems")
    public void getAllFoodItems(SocketIOClient client, AckRequest request, Integer data){
//        List<Food> foodItems = (List<Food>) foodDatabaseRepository.findAll();
//        client.sendEvent("getAllFoodItems", foodItems);
    }
    
    public class foodDatabaseComparator implements java.util.Comparator<Food> {
    	public foodDatabaseComparator() {
            super();
        }
    	
        public int compare(Food s1, Food s2) {
        	if(s1.getName().length() > s2.getName().length()){
        		return 1;
        	}
        	else if(s1.getName().length() < s2.getName().length()){
        		return -1;
        	}
        	else{
        		return 0;
        	}
        }
    }
    
}
