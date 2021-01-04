package pl.agh.servicehistory.web;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.servicehistory.model.CalorieHistory;
import pl.agh.servicehistory.model.MealCalculated;
import pl.agh.servicehistory.service.HistoryServiceImpl;

import java.util.List;

@RestController
@Log4j
public class HistoryController {

    @Autowired
    private HistoryServiceImpl historyService;

    @PostMapping("putMeal/")
    public CalorieHistory saveMeal(@RequestBody MealCalculated meal) {
        log.debug(getClass() + " caught POST request with body:\n" + meal);
        return historyService.saveMeal(meal);
    }

    @GetMapping("getMealsHistory/")
    public List<CalorieHistory> getHistory() {
        log.debug(getClass() + " caught GET request");
        return historyService.getHistory();
    }
}
