package com.example.healthcare.Service;

import com.example.healthcare.DTO.FoodDTO;
import com.example.healthcare.Entity.FoodEntity;
import com.example.healthcare.Repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public void save(FoodDTO foodDTO) {

        FoodEntity foodEntity = FoodEntity.toFoodEntity(foodDTO);
        foodRepository.save(foodEntity);
    }

    public List<FoodDTO> findAll(){
        List<FoodEntity> foodEntityList =foodRepository.findAll();
        List<FoodDTO> foodDTOList = new ArrayList<>();
        for (FoodEntity foodEntity: foodEntityList){
            foodDTOList.add(FoodDTO.toFoodDTO(foodEntity));
        }
        return foodDTOList;
    }
    public FoodDTO findById(Long foodId){
        Optional<FoodEntity> optionalFoodEntity =foodRepository.findByFoodId(foodId);
        if(optionalFoodEntity.isPresent()){
            return FoodDTO.toFoodDTO(optionalFoodEntity.get());
        } else {
            return null;
        }
    }
    public void delete(Long foodId){
        foodRepository.deleteById(foodId);
    }

    public FoodDTO update(FoodDTO foodDTO) {
        FoodEntity foodEntity = FoodEntity.toUpdateEntity(foodDTO);
        foodRepository.save(foodEntity);
        return findById(foodDTO.getFoodId());
    }
}
