package com.mudigal.one;

import com.mudigal.one.domain.NameValue;
import com.mudigal.one.service.CalorieService;
import com.mudigal.one.service.NameValueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Vijayendra Mudigal
 */

@EnableScheduling
@SpringBootApplication // This application works with Spring Boot framework
@EnableDiscoveryClient
@EnableReactiveMongoRepositories
public class ServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }

    /**
     * Runs automatically after application startup
     */
    @Bean
    CommandLineRunner run(NameValueService nameValueService, CalorieService calorieService) {
        return args -> {
            handleNameValue(nameValueService);
            handleCalorieValue(calorieService);
        };
    }

    private void handleNameValue(NameValueService nameValueService) {
        NameValue nameValue = nameValueService.generateUUID();
        nameValueService.updateNameValue(nameValue, false);
    }

    private void handleCalorieValue(CalorieService calorieCalculatorService) {
        String randomCalorieData = calorieCalculatorService.getRandomCalorieData();
        calorieCalculatorService.setCalorieData(randomCalorieData);
    }

}
