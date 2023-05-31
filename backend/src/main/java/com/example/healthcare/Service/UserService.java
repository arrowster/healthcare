package com.example.healthcare.Service;

import com.example.healthcare.DTO.UserDTO;
import com.example.healthcare.Entity.UserEntity;
import com.example.healthcare.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDTO userDTO){

        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
    }
    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> byUserEmail = userRepository.findByUserEmail(userDTO.getUserEmail());
        if (byUserEmail.isPresent()) {
            UserEntity userEntity = byUserEmail.get();
            if (userEntity.getUserPwd().equals(userDTO.getUserPwd())) {
                UserDTO dto = userDTO.toUserDTO(userEntity);
                return dto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    public List<UserDTO> findAll(){
        List<UserEntity> userEntityList =userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity: userEntityList){
            userDTOList.add(UserDTO.toUserDTO(userEntity));
        }
        return userDTOList;
    }
    public UserDTO findById(Long userId){
        Optional<UserEntity> optionalUserEntity =userRepository.findById(userId);
        if(optionalUserEntity.isPresent()){
            return UserDTO.toUserDTO(optionalUserEntity.get());
        } else {
            return null;
        }
    }
    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

    public UserDTO update(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUpdateEntity(userDTO);
        userRepository.save(userEntity);
        return findById(userDTO.getUserId());
    }
}
