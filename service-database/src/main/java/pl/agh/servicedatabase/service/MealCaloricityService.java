package pl.agh.servicedatabase.service;

import pl.agh.servicedatabase.model.AvailableMeals;
import pl.agh.servicedatabase.model.MealCaloricity;

public interface MealCaloricityService {

    MealCaloricity getMealCaloricity(Long id);
    AvailableMeals getAvailableMeals();
}
