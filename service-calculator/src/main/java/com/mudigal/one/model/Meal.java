package com.mudigal.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document // Tells that this class is like "Entity" for MongoDB
@Data // Generates getters, setters, etc.
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    private Long id;

    private Integer grams;

}
