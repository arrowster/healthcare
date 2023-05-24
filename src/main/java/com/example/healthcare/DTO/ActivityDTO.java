package com.example.healthcare.DTO;

import com.example.healthcare.Entity.ActivityEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActivityDTO {
    private Long ActivityId;
    private String ActivityName;
    private String ActivityCal;
    private String ActivityInfo;

    public static ActivityDTO toActivityDTO(ActivityEntity ActivityEntity){
        ActivityDTO ActivityDTO =new ActivityDTO();
        ActivityDTO.setActivityId(ActivityEntity.getActivityId());
        ActivityDTO.setActivityName(ActivityEntity.getActivityName());
        ActivityDTO.setActivityCal(ActivityEntity.getActivityCal());
        ActivityDTO.setActivityInfo(ActivityEntity.getActivityInfo());
        

        return ActivityDTO;
    }
}
