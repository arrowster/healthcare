package com.example.healthcare.Controller;

import com.example.healthcare.DTO.FoodDTO;
import com.example.healthcare.Service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> save(@RequestParam("foodFile") MultipartFile file, @ModelAttribute("foodDTO") FoodDTO foodDTO) throws IOException {
        foodDTO.setFoodFile(file);
        System.out.println("foodDTO = " + foodDTO);
        foodService.save(foodDTO);
        return ResponseEntity.ok("success");
    }
}
