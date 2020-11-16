package com.mudigal.two.service;

import com.mudigal.two.domain.MealCaloricity;
import org.springframework.stereotype.Service;

@Service
public interface MealCaloricityService {

    MealCaloricity getMealCaloricity(Long id);

    MealCaloricity addMealCaloricity(MealCaloricity mealCaloricity);

}
