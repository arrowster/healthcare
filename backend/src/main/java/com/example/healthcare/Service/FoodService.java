package com.example.healthcare.Service;

import com.example.healthcare.DTO.FoodDTO;
import com.example.healthcare.Entity.FoodEntity;
import com.example.healthcare.Entity.FoodFileEntity;
import com.example.healthcare.Repository.FoodFileRepository;
import com.example.healthcare.Repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodFileRepository foodFileRepository;

    public List<String> findByStoredFileName() throws IOException{
        List<FoodFileEntity> foodPhotos = foodFileRepository.findByStoredFileNameIsNotNull();
        List<String> foodPath = new ArrayList<>();

        for (FoodFileEntity foodPhoto : foodPhotos) {
            String storedFileName = foodPhoto.getStoredFileName();
            String filePath = "C:/Users/kjy98/project/storage/" + storedFileName;
            foodPhoto.setFilePath(filePath);
            foodPath.add(foodPhoto.getFilePath());
        }
        return foodPath;
    }

    public void save(FoodDTO foodDTO) throws  IOException{
        //파일 첨부 여부에 따라 로직 분리
        if(foodDTO.getFoodFile().isEmpty()) {
            FoodEntity foodEntity = FoodEntity.toFoodEntity(foodDTO);
            foodRepository.save(foodEntity);
        }
        else{
            //첨부파일 있음.
            MultipartFile foodFile = foodDTO.getFoodFile();
            String originalFileName = foodFile.getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "_" +originalFileName;
            String savePath = "C:/Users/kjy98/project/storage/" + storedFileName;   //C:/Users/kjy98/project/storage/
            try {
                foodFile.transferTo(new File(savePath));
            } catch (IOException e){
                e.printStackTrace();
            }
            FoodEntity foodEntity = FoodEntity.toFoodFileEntity(foodDTO);
            Long savedId = foodRepository.save(foodEntity).getFoodId();
            FoodEntity food = foodRepository.findByFoodId(savedId).get();
            FoodFileEntity foodFileEntity = FoodFileEntity.toFoodFileEntity(food, originalFileName,storedFileName);
            foodFileRepository.save(foodFileEntity);
        }
    }
    @Transactional
    public List<FoodDTO> findAll(){
        List<FoodEntity> foodEntityList =foodRepository.findAll();
        List<FoodDTO> foodDTOList = new ArrayList<>();
        for (FoodEntity foodEntity: foodEntityList){
            foodDTOList.add(FoodDTO.toFoodDTO(foodEntity));
        }
        return foodDTOList;
    }
    @Transactional
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
