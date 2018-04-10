/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS.Controllers;

import com.WS.Entity.Food;
import com.WS.Repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller that handles HTTP requests that require queries to the Foods
 * table.
 *
 * @author YT_6
 *
 */
@Component
@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final Logger logger = LoggerFactory.getLogger(FoodController.class);

    /**
     * Repository handling food table.
     */
    private final FoodRepository foodRepository;

    /**
     * Creates controller that handles HTTP requests that require do queries to
     * the Food table.
     *
     * @param foodRepository Repository handing Foods table.
     */
    @Autowired
    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    /**
     * HTTP request for food types able to be used for ingredients of a recipe
     * or pantry.
     *
     * @param name The name of the food to be searched in the food database.
     * @return A list of food containing the word searched in an order
     * determined by relevance (determined by an algorithm)
     */
    @RequestMapping("/searchByName")
    public List<Food> getFoods(@RequestBody String name) {
        List<Food> foodMaster = foodRepository.findByNameContaining(name);
        List<Food> foods = new ArrayList<>(foodMaster);
        List<Food> foodsStartingWith = new ArrayList<>();
        List<Food> foodsWithStrictlyWord = new ArrayList<>();
        List<Food> foodsWithSingularWord = new ArrayList<>();
        name = name.toLowerCase();
        int dataLength = name.length();
        for (Food h : foodMaster) {
            String fi = h.getName();
            String foodItem = fi.toLowerCase();
            if (foodItem.indexOf(name) == 0) {
                if (foodItem.length() > dataLength) {
                    char followingChar = foodItem.charAt(dataLength);
                    if (Character.isSpaceChar(followingChar) || followingChar == ',') {
                        foodsWithStrictlyWord.add(h);
                        foods.remove(h);
                    } else {
                        foodsStartingWith.add(h);
                        foods.remove(h);
                    }
                } else {
                    foodsWithStrictlyWord.add(h);
                    foods.remove(h);
                }
            } else {
                int ind = foodItem.indexOf(name);
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
        FoodController.foodComparator fdc = new FoodController.foodComparator();
        ArrayList<Food> finalList = new ArrayList<>();
        java.util.Collections.sort(foods, fdc);
        java.util.Collections.sort(foodsStartingWith, fdc);
        java.util.Collections.sort(foodsWithStrictlyWord, fdc);
        java.util.Collections.sort(foodsWithSingularWord, fdc);
        finalList.addAll(foodsWithStrictlyWord);
        finalList.addAll(foodsStartingWith);
        finalList.addAll(foodsWithSingularWord);
        finalList.addAll(foods);
        return finalList;
    }

    private class foodComparator implements java.util.Comparator<Food> {

        public foodComparator() {
            super();
        }

        public int compare(Food s1, Food s2) {
            if (s1.getName().length() > s2.getName().length()) {
                return 1;
            } else if (s1.getName().length() < s2.getName().length()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
