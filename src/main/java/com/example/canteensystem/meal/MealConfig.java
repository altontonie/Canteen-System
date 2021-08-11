package com.example.canteensystem.meal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MealConfig {

    @Bean
    CommandLineRunner commandLineRunnerMeal(MealRepository repository){
        return args -> {
            Meal sadza = new Meal(
                    "sadza",
                    "4",
                    "nuts");

            Meal rice = new Meal(
                    "rice",
                    "5",
                    "milk");

            Meal potatoes = new Meal(
                    "potatoes",
                    "3",
                    "nuts");

            repository.saveAll(
                    List.of(sadza,rice,potatoes)
            );
        };
    }

}
