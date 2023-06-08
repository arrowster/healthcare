package com.example.healthcare.Service;

/*import com.example.healthcare.DTO.Basic_Metabolic_Calculator_DTO;
import com.example.healthcare.Entity.Basic_Metabolic_Calculator_Entity;
import com.example.healthcare.Repository.Basic_Metabolic_Calculator_Repository;*/
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Basic_Metabolic_Calculator_Service {
    public double harrisBenedict_calc(boolean sex, double weight, double height, int old){
        if (sex){   //여성이면
            return 447.6 + (9.25 * weight) + (3.1 * height) - (4.33 * old);
        } else {    //남성이면
            return 88.4 + (13.4 * weight) + (4.8 * height) - (5.68 * old);
        }
    }
    public double miffinStJeor_calc(boolean sex, double weight, double height, int old){
        double result = (9.99 * weight) + (6.25 * height) - (4.95 * old);
        if (sex){   //여성이면
            result -= 161;
        } else {    //남성이면
            result += 5;
        }
        return result;
    }
    public double checkExercise(int Exercise){
        return switch (Exercise) {
            case 0 -> 1.2;
            case 1 -> 1.375;
            case 2 -> 1.55;
            case 3 -> 1.725;
            default -> 1.9;
        };
    }
    public double active_Metabolic_Calculator(boolean sex, double weight, double height, int old, boolean usedCalc, int exercise){ //exercise(0~4)
        if (usedCalc){  //헤리스 베네딕트 공식 이용
            return harrisBenedict_calc(sex, weight, height, old) * checkExercise(exercise);
        } else {    // 미플린 지어 공식 이용
            return miffinStJeor_calc(sex, weight, height, old) * checkExercise(exercise);
        }
    }
}
