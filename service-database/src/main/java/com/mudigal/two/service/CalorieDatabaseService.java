package com.mudigal.two.service;

import com.mudigal.two.domain.Meal;
import org.springframework.stereotype.Service;

@Service
public interface CalorieDatabaseService {

    void addCalorieValue(Meal meal);

    Meal getCalorieValue(Long id);

}
