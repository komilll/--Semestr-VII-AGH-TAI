package com.mudigal.one.service;

import com.mudigal.one.model.Meal;
import com.mudigal.one.model.MealCalculated;

public interface CalorieService {

    String getRandomCalorieData();

    MealCalculated calculateMeal(Meal meal);

}
