package pl.agh.servicehistory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MealCalculated {

    private Long id;

    private Integer grams;

    private Double kcal;

}
