package com.example.healthcare.Entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
@Table(name= "foodfile")
//상속 안넣음
public class FoodFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column
    String originalFileName;

    @Column
    String storedFileName;

    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="food_id")
    private FoodEntity foodEntity;

    public static FoodFileEntity toFoodFileEntity(FoodEntity foodEntity, String originalFileName,String storedFileName){
        FoodFileEntity foodFileEntity = new FoodFileEntity();
        foodFileEntity.setOriginalFileName(originalFileName);
        foodFileEntity.setStoredFileName(storedFileName);
        foodFileEntity.setFoodEntity(foodEntity);

        return foodFileEntity;
    }

}
