package com.example.healthcare.Service;

import com.example.healthcare.DTO.ActivityDTO;
import com.example.healthcare.Entity.ActivityEntity;
import com.example.healthcare.Repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    public void save(ActivityDTO activityDTO) {
        ActivityEntity activityEntity = ActivityEntity.toActivityEntity(activityDTO);
        activityRepository.save(activityEntity);
    }

    public List<ActivityDTO> findAll() {
        List<ActivityEntity> activityEntityList = activityRepository.findAll();
        List<ActivityDTO> activityDTOList = new ArrayList<>();
        for (ActivityEntity activityEntity : activityEntityList) {
            activityDTOList.add(ActivityDTO.toActivityDTO(activityEntity));
        }
        return activityDTOList;
    }

    public ActivityDTO findById(Long activityId) {
        Optional<ActivityEntity> optionalActivityEntity = activityRepository.findByActivityId(activityId);
        if (optionalActivityEntity.isPresent()) {
            return ActivityDTO.toActivityDTO(optionalActivityEntity.get());
        } else {
            return null;
        }
    }

    public void delete(Long activityId) {
        activityRepository.deleteById(activityId);
    }

    public ActivityDTO update(ActivityDTO activityDTO) {
        ActivityEntity activityEntity = ActivityEntity.toUpdateEntity(activityDTO);
        activityRepository.save(activityEntity);
        return findById(activityDTO.getActivityId());
    }
}
