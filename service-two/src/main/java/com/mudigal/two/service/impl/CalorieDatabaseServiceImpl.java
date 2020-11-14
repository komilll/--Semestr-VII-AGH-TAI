package com.mudigal.two.service.impl;

import com.mudigal.two.domain.CalorieValue;
import com.mudigal.two.repository.CalorieValueRepository;
import com.mudigal.two.service.CalorieDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalorieDatabaseServiceImpl implements CalorieDatabaseService {

    @Autowired
    private CalorieValueRepository calorieValueRepository;

    @Override
    public void addCalorieValue(CalorieValue calorieValue) {
        calorieValueRepository.save(calorieValue);
    }

    @Override
    @Nullable
    public CalorieValue getCalorieValue(Long id) {
        return calorieValueRepository.findById(id).orElse(null);
    }
}
