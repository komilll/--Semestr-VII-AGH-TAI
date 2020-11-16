package com.mudigal.two.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MealCalorieDTO {

    private Long id;

    private Integer grams;

    private Integer kcal;

}
