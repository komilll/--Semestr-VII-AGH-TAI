package com.mudigal.one.dao;

import com.mudigal.one.model.CalorieValue;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Generates basic CRUD operations implementations.
 */
@Repository // Google for: Repository Design Pattern
public interface CalorieValueRepository extends ReactiveMongoRepository<CalorieValue, String> {

}
