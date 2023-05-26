package com.example.healthcare.Entity;

import com.example.healthcare.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.healthcare.DTO.FoodDTO;

@Entity
@Setter
@Getter
@Table(name= "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column
    private String foodName;

    @Column
    private String foodInfo;

    @Column
    private String foodProtein;

    public static FoodEntity toFoodEntity(FoodDTO foodDTO){
        FoodEntity foodEntity =new FoodEntity();
        foodEntity.setFoodName(foodDTO.getFoodName());
        foodEntity.setFoodInfo(foodDTO.getFoodInfo());
        foodEntity.setFoodProtein(foodDTO.getFoodProtein());

        return foodEntity;
    }
    public static FoodEntity toUpdateEntity(FoodDTO foodDTO){
        FoodEntity foodEntity =new FoodEntity();
        foodEntity.setFoodId(foodDTO.getFoodId());
        foodEntity.setFoodName(foodDTO.getFoodName());
        foodEntity.setFoodInfo(foodDTO.getFoodInfo());
        foodEntity.setFoodProtein(foodDTO.getFoodProtein());

        return foodEntity;
    }
}
