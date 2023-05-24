package com.example.healthcare.DTO;

import com.example.healthcare.Entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long userId;
    private String userEmail;
    private String userName;
    private String userPwd;
    private String userAddr;
    private String userWeight;
    private String userHeight;
    private String userPhonenum;
    private String userAuthority;
    private String userAge;
    private String userSex;

    public static UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO =new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserPwd(userEntity.getUserPwd());
        userDTO.setUserAddr(userEntity.getUserAddr());
        userDTO.setUserWeight(userEntity.getUserWeight());
        userDTO.setUserHeight(userEntity.getUserHeight());
        userDTO.setUserPhonenum(userEntity.getUserPhonenum());
        userDTO.setUserAuthority(userEntity.getUserAuthority());
        userDTO.setUserAge(userEntity.getUserAge());
        userDTO.setUserSex(userEntity.getUserSex());

        return userDTO;
    }
}
