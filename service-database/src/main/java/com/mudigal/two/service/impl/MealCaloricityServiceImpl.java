package com.mudigal.two.service.impl;

import com.mudigal.two.domain.MealCaloricity;
import com.mudigal.two.repository.CalorieValueRepository;
import com.mudigal.two.service.MealCaloricityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MealCaloricityServiceImpl implements MealCaloricityService {

    @Autowired
    private CalorieValueRepository calorieValueRepository;

    @Override
    @Nullable
    public MealCaloricity getMealCaloricity(Long id) {
        return calorieValueRepository.findById(id).orElse(null);
    }

    @Override
    public MealCaloricity addMealCaloricity(MealCaloricity mealCaloricity) {
        return calorieValueRepository.save(mealCaloricity);
    }
}
