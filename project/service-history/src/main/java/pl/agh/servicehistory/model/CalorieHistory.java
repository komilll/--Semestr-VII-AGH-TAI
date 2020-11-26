package pl.agh.servicehistory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "calorie_history")
public class CalorieHistory {

    @Id
    private Long id;

    private Integer grams;

    private Double kcal;

    private LocalDateTime date;

    public CalorieHistory(MealCalculated mealCalculated) {
        id = mealCalculated.getId();
        grams = mealCalculated.getGrams();
        kcal = mealCalculated.getKcal();
        date = LocalDateTime.now();
    }
}
