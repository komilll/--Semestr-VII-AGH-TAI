package pl.agh.servicehistory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.servicehistory.model.CalorieHistory;
import pl.agh.servicehistory.model.MealCalculated;
import pl.agh.servicehistory.persistence.MealRepository;

@Service
@Slf4j
public class HistoryServiceImpl {

    @Autowired
    private MealRepository mealRepository;

    public void saveMeal(MealCalculated mealCalculated) {
        CalorieHistory calorieHistory = new CalorieHistory(mealCalculated);
        mealRepository.save(calorieHistory);
    }
}
