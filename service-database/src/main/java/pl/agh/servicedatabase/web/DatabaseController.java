package pl.agh.servicedatabase.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.servicedatabase.model.AvailableMeals;
import pl.agh.servicedatabase.model.MealCaloricity;
import pl.agh.servicedatabase.service.MealCaloricityService;

@RestController
@Slf4j
public class DatabaseController {

    @Autowired
    private MealCaloricityService mealCaloricityService;

    @GetMapping("getMealCaloricity/{id}")
    public MealCaloricity getMealCaloricity(@PathVariable Long id) {
        log.info(getClass() + " caught /" + id + " GET request");
        MealCaloricity mealCaloricity = mealCaloricityService.getMealCaloricity(id);
        log.info("Found mealCaloricity for id=" + id + " is: " + mealCaloricity);
        return mealCaloricity;
    }

    @GetMapping("getAvailableMeals/")
    public AvailableMeals getMealCaloricity() {
        log.info(getClass() + " caught getAvailableMeals GET request");
        return mealCaloricityService.getAvailableMeals();
    }
}
