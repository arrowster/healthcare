package com.example.healthcare.DTO;

import com.example.healthcare.Entity.StandardEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StandardDTO {
    private Long standardId;
    private String standardKcal;
    private String standardSex;
    private String standardAge;
    private String standardWeight;
    private String standardHeight;
    private String standardProtein;

    public static StandardDTO toStandardDTO(StandardEntity standardEntity){
        StandardDTO StandardDTO =new StandardDTO();
        StandardDTO.setStandardId(standardEntity.getStandardId());
        StandardDTO.setStandardKcal(standardEntity.getStandardKcal());
        StandardDTO.setStandardSex(standardEntity.getStandardSex());
        StandardDTO.setStandardAge(standardEntity.getStandardAge());
        StandardDTO.setStandardWeight(standardEntity.getStandardWeight());
        StandardDTO.setStandardHeight(standardEntity.getStandardHeight());
        StandardDTO.setStandardProtein(standardEntity.getStandardProtein());

        return StandardDTO;
    }
}
