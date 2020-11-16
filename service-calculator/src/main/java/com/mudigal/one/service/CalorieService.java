package com.mudigal.one.service;

import com.mudigal.one.model.Meal;

public interface CalorieService {

    String getRandomCalorieData();

    void setCalorieData(String randomCalorieData);

    void addNewMeal(Meal meal);
}
