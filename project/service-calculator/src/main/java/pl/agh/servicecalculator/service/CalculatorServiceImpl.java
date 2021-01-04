package pl.agh.servicecalculator.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.agh.servicecalculator.model.CalorieHistory;
import pl.agh.servicecalculator.model.Meal;
import pl.agh.servicecalculator.model.MealCalculated;
import pl.agh.servicecalculator.model.MealCaloricity;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    private final RestTemplate restTemplate;

    public CalculatorServiceImpl() {
        restTemplate = new RestTemplateBuilder().build();
    }

    @SneakyThrows
    @Override
    @Nullable
    public MealCalculated calculateMeal(Meal meal) {
        ResponseEntity<MealCaloricity> getMealCaloricityResponse = getMealCaloricity(meal);
        if (!getMealCaloricityResponse.getStatusCode().is2xxSuccessful()) {
            log.error("GetMealCaloricity failed for meal: " + meal + ", error: " + getMealCaloricityResponse.getStatusCodeValue());
            return null;
        }

        MealCalculated mealCalculated = calculateMeal(meal, getMealCaloricityResponse.getBody());
        ResponseEntity<CalorieHistory> putMealResponse = putMealToHistory(mealCalculated);
        if (!putMealResponse.getStatusCode().is2xxSuccessful()) {
            log.error("Put meal to history failed for meal: " + meal + ", error: " + putMealResponse.getStatusCodeValue());
            return null;
        }

        return mealCalculated;
    }

    private ResponseEntity<MealCaloricity> getMealCaloricity(Meal meal) {
        String url = "http://service-database:6666/getMealCaloricity/" + meal.getId();
        return restTemplate.getForEntity(url, MealCaloricity.class);
    }

    private static MealCalculated calculateMeal(Meal meal, MealCaloricity mealCaloricity) {
        Double kcal = mealCaloricity.getCaloricity() * meal.getGrams();
        MealCalculated mealCalculated = new MealCalculated(meal.getId(), meal.getGrams(), kcal);
        log.info("Meal has been calculated: " + mealCalculated);
        return mealCalculated;
    }

    private ResponseEntity<CalorieHistory> putMealToHistory(MealCalculated mealCalculated) {
        String url = "http://service-history:7777/putMeal/";
        return restTemplate.postForEntity(url, mealCalculated, CalorieHistory.class);
    }
}
