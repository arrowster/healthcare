package com.example.healthcare.DTO;

import com.example.healthcare.Entity.FoodEntity;
import lombok.*;

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

    public static FoodDTO toFoodDTO(FoodEntity foodEntity){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setFoodId(foodEntity.getFoodId());
        foodDTO.setFoodName(foodEntity.getFoodName());
        foodDTO.setFoodInfo(foodEntity.getFoodInfo());
        foodDTO.setFoodProtein(foodEntity.getFoodProtein());

        return foodDTO;
    }
}
