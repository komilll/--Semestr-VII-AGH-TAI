package pl.agh.servicehistory.web;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.servicehistory.model.MealCalculated;
import pl.agh.servicehistory.service.HistoryServiceImpl;

@RestController
@Log4j
public class HistoryController {

    @Autowired
    private HistoryServiceImpl historyService;

    @PostMapping
    public void saveMeal(@RequestBody MealCalculated meal) {
        log.debug(getClass() + " caught POST request with body:\n" + meal);
        historyService.saveMeal(meal);
    }
}
