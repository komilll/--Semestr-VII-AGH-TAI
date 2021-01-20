package pl.agh.servicecalculator.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
    public MealCalculated calculateMeal(Meal meal, String authorization) {
        ResponseEntity<MealCaloricity> caloricityResponse = getMealCaloricity(meal, authorization);
        if (!caloricityResponse.getStatusCode().is2xxSuccessful()) {
            log.error("GetMealCaloricity failed for meal: " + meal + ", error: " + caloricityResponse.getStatusCodeValue());
            return null;
        }

        MealCalculated mealCalculated = calculateMeal(meal, caloricityResponse.getBody());
        ResponseEntity<CalorieHistory> putMealResponse = putMealToHistory(mealCalculated, authorization);
        if (!putMealResponse.getStatusCode().is2xxSuccessful()) {
            log.error("Put meal to history failed for meal: " + meal + ", error: " + putMealResponse.getStatusCodeValue());
            return null;
        }

        return mealCalculated;
    }

    private ResponseEntity<MealCaloricity> getMealCaloricity(Meal meal, String authorization) {
        String url = "http://api-gateway:8080/service-database/getMealCaloricity/" + meal.getId();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", authorization);
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), MealCaloricity.class);
    }

    private static MealCalculated calculateMeal(Meal meal, MealCaloricity mealCaloricity) {
        Double kcal = mealCaloricity.getCaloricity() * meal.getGrams();
        MealCalculated mealCalculated = new MealCalculated(meal.getId(), meal.getGrams(), kcal);
        log.info("Meal has been calculated: " + mealCalculated);
        return mealCalculated;
    }

    private ResponseEntity<CalorieHistory> putMealToHistory(MealCalculated mealCalculated, String authorization) {
        String url = "http://api-gateway:8080/service-history/putMeal/";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", authorization);
        HttpEntity<Object> httpEntity = new HttpEntity<>(mealCalculated, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, CalorieHistory.class);
    }
}
