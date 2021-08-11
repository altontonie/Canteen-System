package com.example.canteensystem.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    Optional<Meal> findMealByMealName(String mealName);

    Optional<Meal> findAllByAllergyIsNot(String allergy);

    List<Meal> findMealByAllergyNotContaining(String allergy);

}

