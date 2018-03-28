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

@Component
@RestController
@RequestMapping("/api/users")
public class FoodController {

    private final Logger logger = LoggerFactory.getLogger(FoodController.class);
    @Autowired
    private FoodRepository foodRepository;

    public FoodController() {
    }

    @RequestMapping("/getFoodsByName")
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

    public class foodComparator implements java.util.Comparator<Food> {
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
