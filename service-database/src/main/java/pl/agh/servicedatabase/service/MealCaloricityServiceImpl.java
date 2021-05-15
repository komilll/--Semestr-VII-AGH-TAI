package pl.agh.servicedatabase.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pl.agh.servicedatabase.model.AvailableMeals;
import pl.agh.servicedatabase.model.MealCaloricity;
import pl.agh.servicedatabase.persistence.MealCaloricityDatabase;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class MealCaloricityServiceImpl implements MealCaloricityService {

    private MealCaloricityDatabase mealsDatabase = new MealCaloricityDatabase();

    @SneakyThrows
    @Override
    public MealCaloricity getMealCaloricity(Long id) {
        int delay = ThreadLocalRandom.current().nextInt(0, 500);
        Thread.sleep(delay);
        return mealsDatabase.getMealCaloricity(id);
    }

    @Override
    public AvailableMeals getAvailableMeals() { return mealsDatabase.getAvailableMeals(); }
}
