package com.example.healthcare.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.healthcare.DTO.UserDTO;

@Entity
@Setter
@Getter
@Table(name= "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique=true)
    private String userEmail;

    @Column

    private String userName;

    @Column
    private String userPwd;

    @Column
    private String userAddr;

    @Column
    private String userWeight;

    @Column
    private String userHeight;

    @Column
    private String userPhonenum;

    @Column
    private String userAuthority;

    @Column
    private String userAge;

    @Column
    private String userSex;

    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPwd(userDTO.getUserPwd());
        userEntity.setUserAddr(userDTO.getUserAddr());
        userEntity.setUserWeight(userDTO.getUserWeight());
        userEntity.setUserHeight(userDTO.getUserHeight());
        userEntity.setUserPhonenum(userDTO.getUserPhonenum());
        userEntity.setUserAuthority(userDTO.getUserAuthority());
        userEntity.setUserAge(userDTO.getUserAge());
        userEntity.setUserSex(userDTO.getUserSex());

        return userEntity;
    }

    public static UserEntity toUpdateEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPwd(userDTO.getUserPwd());
        userEntity.setUserAddr(userDTO.getUserAddr());
        userEntity.setUserWeight(userDTO.getUserWeight());
        userEntity.setUserHeight(userDTO.getUserHeight());
        userEntity.setUserPhonenum(userDTO.getUserPhonenum());
        userEntity.setUserAuthority(userDTO.getUserAuthority());
        userEntity.setUserAge(userDTO.getUserAge());
        userEntity.setUserSex(userDTO.getUserSex());

        return userEntity;
    }
}
