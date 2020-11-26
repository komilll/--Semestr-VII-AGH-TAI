package pl.agh.servicehistory.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.agh.servicehistory.model.CalorieHistory;

@Repository
public interface MealRepository extends MongoRepository<CalorieHistory, Long> {

}
