package pl.agh.servicedatabase.service;

import org.springframework.stereotype.Service;
import pl.agh.servicedatabase.model.AvailableMeals;
import pl.agh.servicedatabase.model.MealCaloricity;
import pl.agh.servicedatabase.persistence.MealCaloricityDatabase;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealCaloricityServiceImpl implements MealCaloricityService {

    private MealCaloricityDatabase mealsDatabase = new MealCaloricityDatabase();

    @Override
    public MealCaloricity getMealCaloricity(Long id) {
        return mealsDatabase.getMealCaloricity(id);
    }

    @Override
    public AvailableMeals getAvailableMeals() { return mealsDatabase.getAvailableMeals(); }
}
