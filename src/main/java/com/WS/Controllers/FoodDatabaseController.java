/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.WS.Entity.Food;
import com.WS.Entity.Food;
import com.WS.Entity.Recipe;
import com.WS.Repository.FoodDatabaseRepository;
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
	private FoodDatabaseRepository foodDatabaseRepository;

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
        List<FoodDatabase> foodMaster = foodDatabaseRepository.findByNameContaining(data);
        List<FoodDatabase> foods = new ArrayList<FoodDatabase>(foodMaster);
        List<FoodDatabase> foodsStartingWith = new ArrayList<FoodDatabase>();
        List<FoodDatabase> foodsWithStrictlyWord = new ArrayList<FoodDatabase>();
        List<FoodDatabase> foodsWithSingularWord = new ArrayList<FoodDatabase>();
        int dataLength = data.length();
        for(FoodDatabase h: foodMaster){
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
            	if(!Character.isLetter(foodItem.charAt(ind - 1))){
            		if(ind + dataLength < foodItem.length() && !Character.isLetter(foodItem.charAt(ind + dataLength))){
            			foodsWithSingularWord.add(h);
            			foods.remove(h);
            		}
            		else if(ind + dataLength == foodItem.length()){
            			foodsWithSingularWord.add(h);
            			foods.remove(h);
            		}
            	}
            }
        }
        foodDatabaseComparator fdc = new foodDatabaseComparator();
        ArrayList<FoodDatabase> finalList = new ArrayList<FoodDatabase>();
        java.util.Collections.sort(foods, fdc);
        java.util.Collections.sort(foodsStartingWith, fdc);
        java.util.Collections.sort(foodsWithStrictlyWord, fdc);
        java.util.Collections.sort(foodsWithSingularWord, fdc);
        finalList.addAll(foodsWithStrictlyWord);
        finalList.addAll(foodsStartingWith);
        finalList.addAll(foodsWithSingularWord);
        finalList.addAll(foods);
        for(FoodDatabase e : finalList){
        	System.out.println(e.getName());
        }
    	client.sendEvent("getFoodItemsByName", finalList);
    }
    
    @OnEvent(value = "getAllFoodItems")
    public void getAllFoodItems(SocketIOClient client, AckRequest request, Integer data){
//        List<FoodDatabase> foodItems = (List<FoodDatabase>) foodDatabaseRepository.findAll();
//        client.sendEvent("getAllFoodItems", foodItems);
    }
    
    public class foodDatabaseComparator implements java.util.Comparator<FoodDatabase> {
    	public foodDatabaseComparator() {
            super();
        }
    	
        public int compare(FoodDatabase s1, FoodDatabase s2) {
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
