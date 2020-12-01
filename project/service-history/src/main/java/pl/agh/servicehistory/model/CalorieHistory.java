package pl.agh.servicehistory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "calorie_history")
@NoArgsConstructor
@AllArgsConstructor
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
