package com.mudigal.two.service;

import com.mudigal.two.domain.CalorieValue;
import org.springframework.stereotype.Service;

@Service
public interface CalorieDatabaseService {

    void addCalorieValue(CalorieValue calorieValue);

    CalorieValue getCalorieValue(Long id);

}
