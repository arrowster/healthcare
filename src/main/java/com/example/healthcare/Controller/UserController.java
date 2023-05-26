package com.example.healthcare.Controller;

import com.example.healthcare.DTO.UserDTO;
import com.example.healthcare.Service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/user/save")
    public ResponseEntity save(@RequestBody UserDTO userDTO) {   //state code
        System.out.println("UserController.save");
        System.out.println("userDTO ="+ userDTO);
        userService.save(userDTO);
        return ResponseEntity.ok(200);
    }


    @GetMapping("/user/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO, HttpSession session) {
        UserDTO loginResult = userService.login(userDTO);
        if (loginResult != null) {
            session.setAttribute("loginEmail",loginResult.getUserId());
            if (loginResult.getUserAuthority().equals("1")) {
                Map<String, Object> response = new HashMap<>();
                response.put("userType", "admin");
                response.put("userInfo", loginResult);
                return ResponseEntity.ok().body(response);
                //return ResponseEntity.ok().body("admin");
            } else {
                return ResponseEntity.ok().body(loginResult);
            }
            //UserDTO의 userAuthority 값이 0일 때 일반 사용자
            //UserDTO의 userAuthority 값이 1일 때 관리자 계정
        } else {
            // login 실패
            return ResponseEntity.status(404).body(404);//"login";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "index";
    }



    @GetMapping("/user/")
    public String findAll(Model model){
        List<UserDTO> userDTOList = userService.findAll();
        model.addAttribute("userList",userDTOList);
        return "list";
    }
    @GetMapping("/user/{userId}")
    public String findById(@PathVariable Long userId,Model model){
        UserDTO userDTO = userService.findById(userId);
        model.addAttribute("user",userDTO);
        return "detail";
    }

    @GetMapping("/user/admin")
    public String adminForm() {return "admin";}

    @GetMapping("/user/customer")
    public String customerForm() {return "customer";}

    @GetMapping("/user/delete/{userId}")
    public String delete(@PathVariable Long userId) {
        userService.delete(userId);
        return "redirect:/user/";
    }

    @GetMapping("/user/update/{userId}")
    public String updateForm(@PathVariable Long userId, Model model) {
        UserDTO userDTO = userService.findById(userId);
        model.addAttribute("userUpdate", userDTO);
        return "userupdate";
    }
    @PostMapping("/user/update")
    public String update(@ModelAttribute UserDTO userDTO, Model model) {
        UserDTO user = userService.update(userDTO);
        model.addAttribute("user",user);
        return "detail";
    }
}
