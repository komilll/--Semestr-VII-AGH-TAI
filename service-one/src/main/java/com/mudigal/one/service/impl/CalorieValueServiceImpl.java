package com.mudigal.one.service.impl;

import com.mudigal.one.service.CalorieValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CalorieValueServiceImpl implements CalorieValueService {

    private static final Logger logger = LoggerFactory.getLogger(CalorieValueServiceImpl.class);

    @Override
    public String getRandomCalorieData() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        String generatedData = "RandomCalorieData: " + randomNumber;
        logger.info("Generated Data: " + generatedData);
        return generatedData;
    }

    public void setCalorieData(String randomCalorieData) {

    }

}
