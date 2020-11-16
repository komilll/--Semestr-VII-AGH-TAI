package com.mudigal.two.repository;

import com.mudigal.two.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalorieValueRepository extends JpaRepository<Meal, Long> {
}
