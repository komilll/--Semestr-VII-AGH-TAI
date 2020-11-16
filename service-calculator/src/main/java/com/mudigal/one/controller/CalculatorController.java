package com.mudigal.one.controller;

import com.mudigal.one.model.Meal;
import com.mudigal.one.model.MealCalorie;
import com.mudigal.one.service.CalorieService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// This class acts as a controller for REST API requests
@RestController
// Sets endpoint starting path
@RequestMapping
@Log4j
public class CalculatorController {

    // Automatically injects service when instantiating the Controller
    @Autowired
    private CalorieService calorieService;

    // Catches REST API GET methods
    @GetMapping
    public String getRandomCalorieValue() {
        log.debug(this.getClass() + " caught / GET request.");
        return calorieService.getRandomCalorieData();
    }

    @PostMapping
    public void addNewMeal(@RequestBody Meal meal) {
        log.debug(this.getClass() + " caught POST request with body:\n" + meal.toString());
        calorieService.addNewMeal(meal);
    }

    @PostMapping("/calculated")
    public void printCalculatedMeal(@RequestBody MealCalorie mealCalorie) {
        log.debug(this.getClass() + " caught /calculated POST request with body:\n" + mealCalorie.toString());
    }

}
