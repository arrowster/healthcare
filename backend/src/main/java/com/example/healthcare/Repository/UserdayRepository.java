package com.example.healthcare.Repository;

import com.example.healthcare.Entity.UserdayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserdayRepository extends JpaRepository<UserdayEntity, Long>{
    Optional<UserdayEntity> findByUserdayId(Long userdayId);
}
