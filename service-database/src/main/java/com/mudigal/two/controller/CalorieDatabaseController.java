package com.mudigal.two.controller;

import com.mudigal.two.domain.Meal;
import com.mudigal.two.model.MealCalorieDTO;
import com.mudigal.two.service.CalorieDatabaseService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/")
@Slf4j
public class CalorieDatabaseController {

    private final RestTemplate restTemplate;

    public CalorieDatabaseController() {
        restTemplate = new RestTemplateBuilder().build();
    }

    @Autowired
    private CalorieDatabaseService calorieDatabaseService;

    private static HttpHeaders prepareHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @GetMapping("/{id}")
    public Meal getCalorieValue(@PathVariable Long id) {
        log.info(this.getClass() + " caught /" + id + " GET request");
        return calorieDatabaseService.getCalorieValue(id);
    }

    @SneakyThrows
    @PostMapping
    public void addCalorieValue(@RequestBody Meal meal) {
        log.info(this.getClass() + " caught POST request with body:\n" + meal.toString());
//        calorieDatabaseService.addCalorieValue(calorieValue);

        String url = "http://localhost:8082/";
        HttpHeaders headers = prepareHttpHeaders();
        MealCalorieDTO mealCalorieDTO = new MealCalorieDTO(meal.getId(), meal.getGrams(), meal.getGrams() * 400);
        HttpEntity<MealCalorieDTO> requestEntity = new HttpEntity<>(mealCalorieDTO, headers);
        ResponseEntity<MealCalorieDTO> responseEntity = restTemplate.postForEntity(url, requestEntity, MealCalorieDTO.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("New meal calculated: " + mealCalorieDTO);
        } else {
            log.error("Add new meal failed: " + mealCalorieDTO);
        }
    }

}
