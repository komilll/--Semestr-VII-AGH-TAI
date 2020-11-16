package com.mudigal.one.controller;

import com.mudigal.one.model.Meal;
import com.mudigal.one.model.MealCalculated;
import com.mudigal.one.service.CalorieService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Log4j
public class CalculatorController {

    @Autowired
    private CalorieService calorieService;

    @PostMapping
    public MealCalculated calculateMeal(@RequestBody Meal meal) {
        log.debug(getClass() + " caught POST request with body:\n" + meal);
        return calorieService.calculateMeal(meal);
    }

}
