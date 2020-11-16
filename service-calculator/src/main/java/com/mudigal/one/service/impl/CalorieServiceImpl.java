package com.mudigal.one.service.impl;

import com.mudigal.one.model.Meal;
import com.mudigal.one.service.CalorieService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j
public class CalorieServiceImpl implements CalorieService {

    private final RestTemplate restTemplate;

    public CalorieServiceImpl() {
        restTemplate = new RestTemplateBuilder().build();
    }

    private static HttpHeaders prepareHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @Override
    public String getRandomCalorieData() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        String generatedData = "RandomCalorieData: " + randomNumber;
        log.info("Generated Data: " + generatedData);
        return generatedData;
    }

    public void setCalorieData(String randomCalorieData) {

    }

    @SneakyThrows
    @Override
    public void addNewMeal(Meal meal) {
        String url = "http://localhost:8084/";
        HttpHeaders headers = prepareHttpHeaders();
        HttpEntity<Meal> requestEntity = new HttpEntity<>(meal, headers);
        ResponseEntity<Meal> responseEntity = restTemplate.postForEntity(url, requestEntity, Meal.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("Add new meal succeeded: " + meal);
        } else {
            log.error("Add new meal failed");
        }
    }
}
