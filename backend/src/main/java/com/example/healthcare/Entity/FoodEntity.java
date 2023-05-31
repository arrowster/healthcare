package com.example.healthcare.Entity;

import com.example.healthcare.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
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

    @Column
    private int fileAttached; // 1 or 0 파일이 들어가 있나 안있나를 논리적으로 판별

    @OneToMany(mappedBy = "foodEntity",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<FoodFileEntity> foodFileEntityList = new ArrayList<>();

    public static FoodEntity toFoodEntity(FoodDTO foodDTO){
        FoodEntity foodEntity =new FoodEntity();
        foodEntity.setFoodName(foodDTO.getFoodName());
        foodEntity.setFoodInfo(foodDTO.getFoodInfo());
        foodEntity.setFoodProtein(foodDTO.getFoodProtein());
        foodEntity.setFileAttached(0);//파일 없음

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
    public static FoodEntity toFoodFileEntity(FoodDTO foodDTO){
        FoodEntity foodEntity =new FoodEntity();
        foodEntity.setFoodName(foodDTO.getFoodName());
        foodEntity.setFoodInfo(foodDTO.getFoodInfo());
        foodEntity.setFoodProtein(foodDTO.getFoodProtein());
        foodEntity.setFileAttached(1);//파일 있음

        return foodEntity;
    }
}
