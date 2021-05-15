package pl.agh.servicedatabase.persistence;

import pl.agh.servicedatabase.model.AvailableMeals;
import pl.agh.servicedatabase.model.MealCaloricity;
import pl.agh.servicedatabase.model.MealRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MealCaloricityDatabase {

    private Map<Long, MealDatabaseRecord> caloricityMap = new HashMap<Long, MealDatabaseRecord>();

    public MealCaloricityDatabase() {
        caloricityMap.put(1L, new MealDatabaseRecord("Bigos", 61.0));
        caloricityMap.put(2L, new MealDatabaseRecord("Groch", 330.0));
        caloricityMap.put(3L, new MealDatabaseRecord("Hummus", 177.0));
        caloricityMap.put(4L, new MealDatabaseRecord("Kebab", 215.0));
        caloricityMap.put(5L, new MealDatabaseRecord("Lasagna", 132.0));
        caloricityMap.put(6L, new MealDatabaseRecord("Pizza", 267.0));
        caloricityMap.put(7L, new MealDatabaseRecord("Risotto", 118.3));
        caloricityMap.put(8L, new MealDatabaseRecord("Taco", 217.1));
        caloricityMap.put(9L, new MealDatabaseRecord("Ravioli", 203.3));
        caloricityMap.put(10L, new MealDatabaseRecord("Ryz", 361.0));
    }

    public MealCaloricity getMealCaloricity(Long id) {
        MealDatabaseRecord caloricity = caloricityMap.get(id);
        return new MealCaloricity(id, caloricity.caloricity);
    }

    public AvailableMeals getAvailableMeals() {
        ArrayList<MealRecord> meals = new ArrayList<MealRecord>();
        caloricityMap.forEach((id, meal) -> meals.add(new MealRecord(id, meal.name)));

        return new AvailableMeals(meals);
    }
}
