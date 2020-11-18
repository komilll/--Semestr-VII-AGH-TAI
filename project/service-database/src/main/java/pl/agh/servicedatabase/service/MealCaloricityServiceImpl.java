package pl.agh.servicedatabase.service;

import org.springframework.stereotype.Service;
import pl.agh.servicedatabase.model.MealCaloricity;

@Service
public class MealCaloricityServiceImpl implements MealCaloricityService {

    @Override
    public MealCaloricity getMealCaloricity(Long id) {
        return new MealCaloricity(123L, 555.555);
    }
}
