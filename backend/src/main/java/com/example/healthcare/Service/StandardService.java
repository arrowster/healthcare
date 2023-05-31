package com.example.healthcare.Service;

import com.example.healthcare.DTO.StandardDTO;
import com.example.healthcare.Entity.StandardEntity;
import com.example.healthcare.Repository.StandardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StandardService {
    private final StandardRepository standardRepository;

    public void save(StandardDTO standardDTO){

        StandardEntity standardEntity = StandardEntity.toStandardEntity(standardDTO);
        standardRepository.save(standardEntity);
    }

    public List<StandardDTO> findAll(){
        List<StandardEntity> standardEntityList =standardRepository.findAll();
        List<StandardDTO> standardDTOList = new ArrayList<>();
        for (StandardEntity standardEntity: standardEntityList){
            standardDTOList.add(StandardDTO.toStandardDTO(standardEntity));
        }
        return standardDTOList;
    }

    public StandardDTO findById(Long standardId){
        Optional<StandardEntity> optionalStandardEntity =standardRepository.findByStandardId(standardId);
        if(optionalStandardEntity.isPresent()){
            return StandardDTO.toStandardDTO(optionalStandardEntity.get());
        } else {
            return null;
        }
    }

    public void delete(Long standardId){
        standardRepository.deleteById(standardId);
    }

    public StandardDTO update(StandardDTO standardDTO) {
        StandardEntity standardEntity = StandardEntity.toUpdateEntity(standardDTO);
        standardRepository.save(standardEntity);
        return findById(standardDTO.getStandardId());
    }

}
