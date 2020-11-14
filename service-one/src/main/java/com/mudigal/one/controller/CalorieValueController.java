package com.mudigal.one.controller;

import com.mudigal.one.service.CalorieValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class acts as a controller for REST API requests
@RestController
// Sets endpoint starting path
@RequestMapping("/")
public class CalorieValueController {

    private static final Logger logger = LoggerFactory.getLogger(CalorieValueController.class);

    // Automatically injects service when instantiating the Controller
    @Autowired
    private CalorieValueService calorieValueService;

    // Catches REST API GET methods
    @GetMapping
    public String getRandomCalorieValue() {
        logger.debug(this.getClass() + " caught GET request.");
        return calorieValueService.getRandomCalorieData();
    }

}
