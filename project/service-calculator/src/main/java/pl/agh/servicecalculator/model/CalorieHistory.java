package pl.agh.servicecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalorieHistory {

    private Long id;

    private Integer grams;

    private Double kcal;

    private LocalDateTime date;
}
