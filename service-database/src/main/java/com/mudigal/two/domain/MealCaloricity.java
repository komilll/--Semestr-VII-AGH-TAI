package com.mudigal.two.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal_caloricity")
public class MealCaloricity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "caloricity")
    private Double caloricity;

}
