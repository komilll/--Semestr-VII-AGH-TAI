package com.mudigal.one.service.impl;

import com.mudigal.one.model.Meal;
import com.mudigal.one.model.MealCalculated;
import com.mudigal.one.model.MealCaloricity;
import com.mudigal.one.service.CalorieService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j
public class CalorieServiceImpl implements CalorieService {

    private final RestTemplate restTemplate;

    public CalorieServiceImpl() {
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
        String url = "http://localhost:8084/" + meal.getId();
        return restTemplate.getForEntity(url, MealCaloricity.class);
    }

    @Override
    public String getRandomCalorieData() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        String generatedData = "RandomCalorieData: " + randomNumber;
        log.info("Generated Data: " + generatedData);
        return generatedData;
    }
}
