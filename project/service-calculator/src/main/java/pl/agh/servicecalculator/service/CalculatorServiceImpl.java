package pl.agh.servicecalculator.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
        MealCalculated mealCalculated = null;
        ResponseEntity<MealCaloricity> responseEntity = handleRequest(meal);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            mealCalculated = handleSuccess(meal, responseEntity.getBody());
        } else {
            log.error("Add new meal failed for meal: " + meal + ", error: " + responseEntity.getStatusCodeValue());
        }

        return mealCalculated;
    }

    private static MealCalculated handleSuccess(Meal meal, MealCaloricity mealCaloricity) {
        Double kcal = mealCaloricity.getCaloricity() * meal.getGrams();
        MealCalculated mealCalculated = new MealCalculated(meal.getId(), meal.getGrams(), kcal);
        log.info("Meal has been calculated: " + mealCalculated);
        return mealCalculated;
    }

    private ResponseEntity<MealCaloricity> handleRequest(Meal meal) {
        String url = "http://localhost:6666/" + meal.getId();
        return restTemplate.getForEntity(url, MealCaloricity.class);
    }

}
