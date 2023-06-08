package com.example.healthcare.Controller;

import com.example.healthcare.DTO.FoodDTO;
import com.example.healthcare.Service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/photo")
    public ResponseEntity<List<String>> getAllFoodStoredFileNames() throws IOException {
        List<String> foodPaths = foodService.findByStoredFileName();
        List<String> Paths = new ArrayList<>();
        for (String imagePaths : foodPaths) {
            Paths.add(imagePaths);
        }
        return ResponseEntity.ok(Paths);
    }
    @GetMapping("/photo/{fileName}")
    public ResponseEntity<byte[]> getFoodPhoto(@PathVariable String fileName) throws IOException {
        Path imagePath = Paths.get("C:/Users/kjy98/project/storage", fileName);
        byte[] imageBytes = Files.readAllBytes(imagePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

}
