package com.example.healthcare.DTO;

import com.example.healthcare.Entity.FoodEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodDTO {
    private Long foodId;
    private String foodName;
    private String foodInfo;
    private String foodProtein;

    private MultipartFile foodFile;//save.html-> Controller파일 담는 용도
    private String originalFileName;//원본파일 이름
    private String storedFileName;//서버 저장용 파일 이름
    private int fileAttached;// 파일 첨부 여부(첨부 1, 미첨부 0)
    public static FoodDTO toFoodDTO(FoodEntity foodEntity){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setFoodId(foodEntity.getFoodId());
        foodDTO.setFoodName(foodEntity.getFoodName());
        foodDTO.setFoodInfo(foodEntity.getFoodInfo());
        foodDTO.setFoodProtein(foodEntity.getFoodProtein());

        if(foodEntity.getFileAttached()==0){
            foodDTO.setFileAttached(foodEntity.getFileAttached());//0
        } else {
            foodDTO.setFileAttached(foodEntity.getFileAttached());//1
            foodDTO.setOriginalFileName(foodEntity.getFoodFileEntityList().get(0).getOriginalFileName());
            foodDTO.setStoredFileName(foodEntity.getFoodFileEntityList().get(0).getStoredFileName());
        }
        return foodDTO;
    }
}
