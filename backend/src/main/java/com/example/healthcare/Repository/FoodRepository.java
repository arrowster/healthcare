package com.example.healthcare.Repository;

import com.example.healthcare.Entity.FoodEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    Optional<FoodEntity> findByFoodId(Long foodId);
}
