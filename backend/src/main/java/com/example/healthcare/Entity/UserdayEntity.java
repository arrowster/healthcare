package com.example.healthcare.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.healthcare.DTO.UserdayDTO;

@Entity
@Setter
@Getter
@Table(name= "userday")
public class UserdayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userdayId;

    @Column

    private Long userId;

    @Column

    private String userCal;

    @Column

    private String userProtein;

    @Column
    private String userDate;

    public static UserdayEntity toUserdayEntity(UserdayDTO userdayDTO){
        UserdayEntity userdayEntity =new UserdayEntity();
        userdayEntity.setUserId(userdayDTO.getUserId());
        userdayEntity.setUserCal(userdayDTO.getUserCal());
        userdayEntity.setUserProtein(userdayDTO.getUserProtein());
        userdayEntity.setUserDate(userdayDTO.getUserDate());

        return userdayEntity;
    }

    public static UserdayEntity toUpdateEntity(UserdayDTO userdayDTO){
        UserdayEntity userdayEntity =new UserdayEntity();
        userdayEntity.setUserdayId(userdayDTO.getUserdayId());
        userdayEntity.setUserId(userdayDTO.getUserId());
        userdayEntity.setUserCal(userdayDTO.getUserCal());
        userdayEntity.setUserProtein(userdayDTO.getUserProtein());
        userdayEntity.setUserDate(userdayDTO.getUserDate());

        return userdayEntity;
    }
}
