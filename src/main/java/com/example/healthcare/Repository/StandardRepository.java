package com.example.healthcare.Repository;

import com.example.healthcare.Entity.StandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StandardRepository extends JpaRepository<StandardEntity, Long> {
    Optional<StandardEntity> findByStandardId(Long standardId);
}
