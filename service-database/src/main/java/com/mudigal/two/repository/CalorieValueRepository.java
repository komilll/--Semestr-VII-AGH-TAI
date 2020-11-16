package com.mudigal.two.repository;

import com.mudigal.two.domain.CalorieValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalorieValueRepository extends JpaRepository<CalorieValue, Long> {
}
