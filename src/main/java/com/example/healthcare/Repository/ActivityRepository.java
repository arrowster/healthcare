package com.example.healthcare.Repository;

import com.example.healthcare.Entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long>{
    Optional<ActivityEntity> findByActivityId(Long activityId);

}
