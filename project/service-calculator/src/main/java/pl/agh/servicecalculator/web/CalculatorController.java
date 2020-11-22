package pl.agh.servicecalculator.web;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.servicecalculator.model.Meal;
import pl.agh.servicecalculator.model.MealCalculated;
import pl.agh.servicecalculator.service.CalculatorService;

@RestController
@Log4j
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping
    public MealCalculated calculateMeal(@RequestBody Meal meal) {
        log.debug(getClass() + " caught POST request with body:\n" + meal);
        return calculatorService.calculateMeal(meal);
    }
}
