package com.example.healthcare.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.healthcare.DTO.StandardDTO;

@Entity
@Setter
@Getter
@Table(name= "standard")
public class StandardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long standardId;

    @Column

    private String standardKcal;

    @Column

    private String standardSex;

    @Column

    private String standardAge;

    @Column
    private String standardWeight;

    @Column
    private String standardHeight;

    @Column
    private String standardProtein;

    public static StandardEntity toStandardEntity(StandardDTO standardDTO){
        StandardEntity standardEntity =new StandardEntity();
        standardEntity.setStandardKcal(standardDTO.getStandardKcal());
        standardEntity.setStandardSex(standardDTO.getStandardSex());
        standardEntity.setStandardAge(standardDTO.getStandardAge());
        standardEntity.setStandardWeight(standardDTO.getStandardWeight());
        standardEntity.setStandardHeight(standardDTO.getStandardHeight());
        standardEntity.setStandardProtein(standardDTO.getStandardProtein());

        return standardEntity;
    }

    public static StandardEntity toUpdateEntity(StandardDTO standardDTO){
        StandardEntity standardEntity =new StandardEntity();
        standardEntity.setStandardId(standardDTO.getStandardId());
        standardEntity.setStandardKcal(standardDTO.getStandardKcal());
        standardEntity.setStandardSex(standardDTO.getStandardSex());
        standardEntity.setStandardAge(standardDTO.getStandardAge());
        standardEntity.setStandardWeight(standardDTO.getStandardWeight());
        standardEntity.setStandardHeight(standardDTO.getStandardHeight());
        standardEntity.setStandardProtein(standardDTO.getStandardProtein());

        return standardEntity;
    }
}
