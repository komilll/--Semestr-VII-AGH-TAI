package pl.agh.servicehistory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.servicehistory.model.CalorieHistory;
import pl.agh.servicehistory.model.MealCalculated;
import pl.agh.servicehistory.persistence.MealRepository;

import java.util.List;

@Service
@Slf4j
public class HistoryServiceImpl {

    @Autowired
    private MealRepository mealRepository;

    public CalorieHistory saveMeal(MealCalculated mealCalculated) {
        log.info("Trying to save mealCalculated: " + mealCalculated);
        CalorieHistory calorieHistory = new CalorieHistory(mealCalculated);
        log.info("Saved calorieHistory: " + calorieHistory);
        return mealRepository.insert(calorieHistory);
    }

    public List<CalorieHistory> getHistory() {
        log.info("Trying to get all history");
        return mealRepository.findAll();
    }
}
