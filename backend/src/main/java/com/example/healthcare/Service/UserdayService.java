package com.example.healthcare.Service;

import com.example.healthcare.DTO.UserdayDTO;
import com.example.healthcare.Entity.UserdayEntity;
import com.example.healthcare.Repository.UserdayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserdayService {
    private final UserdayRepository userdayRepository;

    public void save(UserdayDTO userdayDTO){

        UserdayEntity userdayEntity = UserdayEntity.toUserdayEntity(userdayDTO);
        userdayRepository.save(userdayEntity);
    }

    public List<UserdayDTO> findAll(){
        List<UserdayEntity> userdayEntityList =userdayRepository.findAll();
        List<UserdayDTO> userdayDTOList = new ArrayList<>();
        for (UserdayEntity userdayEntity: userdayEntityList){
            userdayDTOList.add(UserdayDTO.toUserdayDTO(userdayEntity));
        }
        return userdayDTOList;
    }
    public UserdayDTO findById(Long userdayId){
        Optional<UserdayEntity> optionalUserdayEntity =userdayRepository.findByUserdayId(userdayId);
        if(optionalUserdayEntity.isPresent()){
            return UserdayDTO.toUserdayDTO(optionalUserdayEntity.get());
        } else {
            return null;
        }
    }
    public void delete(Long userdayId){
        userdayRepository.deleteById(userdayId);
    }

    public UserdayDTO update(UserdayDTO userdayDTO) {
        UserdayEntity userdayEntity = UserdayEntity.toUpdateEntity(userdayDTO);
        userdayRepository.save(userdayEntity);
        return findById(userdayDTO.getUserdayId());
    }
}
