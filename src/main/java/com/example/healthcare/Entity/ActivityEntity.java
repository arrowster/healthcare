package com.example.healthcare.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.healthcare.DTO.ActivityDTO;

@Entity
@Setter
@Getter
@Table(name= "activity")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @Column
    private String activityName;

    @Column
    private String activityCal;

    @Column
    private String activityInfo;

    public static ActivityEntity toActivityEntity(ActivityDTO activityDTO){
        ActivityEntity activityEntity =new ActivityEntity();
        activityEntity.setActivityName(activityDTO.getActivityName());
        activityEntity.setActivityCal(activityDTO.getActivityCal());
        activityEntity.setActivityInfo(activityDTO.getActivityInfo());

        return activityEntity;
    }

    public static ActivityEntity toUpdateEntity(ActivityDTO activityDTO){
        ActivityEntity activityEntity =new ActivityEntity();
        activityEntity.setActivityId(activityDTO.getActivityId());
        activityEntity.setActivityName(activityDTO.getActivityName());
        activityEntity.setActivityCal(activityDTO.getActivityCal());
        activityEntity.setActivityInfo(activityDTO.getActivityInfo());

        return activityEntity;
    }
}
