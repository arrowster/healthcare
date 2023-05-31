package com.example.healthcare.DTO;

import com.example.healthcare.Entity.UserdayEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserdayDTO {
    private Long userdayId;
    private Long userId;
    private String userCal;
    private String userProtein;
    private String userDate;


    public static UserdayDTO toUserdayDTO(UserdayEntity userdayEntity){
        UserdayDTO userdayDTO =new UserdayDTO();
        userdayDTO.setUserdayId(userdayEntity.getUserdayId());
        userdayDTO.setUserId(userdayEntity.getUserId());
        userdayDTO.setUserCal(userdayEntity.getUserCal());
        userdayDTO.setUserProtein(userdayEntity.getUserProtein());
        userdayDTO.setUserDate(userdayEntity.getUserDate());

        return userdayDTO;
    }
}
