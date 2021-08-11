package com.example.canteensystem.meal;

import com.example.canteensystem.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {


    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getMenu() {
        return mealRepository.findAll();
    }

    public void addMeal(Meal meal) {
        Optional<Meal> mealServed = mealRepository.findMealByMealName(meal.getMealName());

        if(mealServed.isPresent()){
            throw new IllegalStateException("Meal already served");
        }
        mealRepository.save(meal);
    }

    public List<Meal> getStudentMeal(String allergy) {
        return mealRepository.findMealByAllergyNotContaining(allergy);
    }
}
