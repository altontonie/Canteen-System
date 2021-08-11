package com.example.canteensystem.chef;

import com.example.canteensystem.meal.Meal;
import com.example.canteensystem.meal.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/chef")
public class chefController {

    private final MealService mealService;

    @Autowired
    public chefController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public void addMeals(@RequestBody Meal meal){
        mealService.addMeal(meal);
    }

}
