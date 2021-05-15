package pl.agh.servicecalculator.service;

import pl.agh.servicecalculator.model.Meal;
import pl.agh.servicecalculator.model.MealCalculated;

public interface CalculatorService {

    MealCalculated calculateMeal(Meal meal, String authorization);

}
