package com.mudigal.two.controller;

import com.mudigal.two.domain.CalorieValue;
import com.mudigal.two.service.CalorieDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class CalorieDatabaseController {

    @Autowired
    private CalorieDatabaseService calorieDatabaseService;

    @GetMapping("/{id}")
    public CalorieValue getCalorieValue(@PathVariable Long id) {
        log.info(this.getClass() + " caught GET request.");
        return calorieDatabaseService.getCalorieValue(id);
    }

    @PostMapping
    public void addCalorieValue(@RequestBody CalorieValue calorieValue) {
        log.info(this.getClass() + " caught POST request");
        calorieDatabaseService.addCalorieValue(calorieValue);
    }

}
