package com.mudigal.two.controller;

import com.mudigal.two.domain.MealCaloricity;
import com.mudigal.two.service.MealCaloricityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class MealCaloricityController {

    @Autowired
    private MealCaloricityService mealCaloricityService;

    @GetMapping("/{id}")
    public MealCaloricity getMealCaloricity(@PathVariable Long id) {
        log.info(getClass() + " caught /" + id + " GET request");
        MealCaloricity mealCaloricity = mealCaloricityService.getMealCaloricity(id);
        log.info("Found mealCaloricity for id=" + id + " is: " + mealCaloricity);
        return mealCaloricity;
    }

    @PostMapping
    public MealCaloricity addMealCaloricity(@RequestBody MealCaloricity mealCaloricity) {
        log.info(getClass() + " caught / POST request with body: " + mealCaloricity);
        MealCaloricity savedCaloricity = mealCaloricityService.addMealCaloricity(mealCaloricity);
        log.info("Saved MealCaloricity: " + mealCaloricity);
        return savedCaloricity;
    }

}
