package com.example.healthcare.Repository;

import com.example.healthcare.Entity.FoodFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodFileRepository extends JpaRepository<FoodFileEntity, Long> {
    List<FoodFileEntity> findByStoredFileNameIsNotNull();
}
