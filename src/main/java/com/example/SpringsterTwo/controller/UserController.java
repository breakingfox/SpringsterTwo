package com.example.SpringsterTwo.controller;


import com.example.SpringsterTwo.dto.RegistrationDto;
import com.example.SpringsterTwo.dto.UserDto;
import com.example.SpringsterTwo.entity.users.Role;
import com.example.SpringsterTwo.entity.users.Status;
import com.example.SpringsterTwo.service.security.UserDefaultServiceImpl;
import com.example.SpringsterTwo.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {
    private final UserDefaultServiceImpl userDefaultService;
    private final UserService userService;

    //    @PostMapping("/save")
//    public RecipeDto saveRecipe(@RequestBody RecipeDto recipeDto) throws ValidationException {
//        log.info("Handling save recipe: " + recipeDto);
//        return recipeService.saveRecipe(recipeDto);
//    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/findAll")
    public List<UserDto> findAllUsers() {
        log.info("Handling find all users request");
        return userDefaultService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/save")
    public RegistrationDto registration(@RequestBody RegistrationDto registrationDto) {
        registrationDto.setStatus(Status.ACTIVE);
        registrationDto.setRole(Role.USER);
        registrationDto.setPassword(new BCryptPasswordEncoder(12).encode(registrationDto.getPassword()));
        return userService.saveUser(registrationDto);
    }
//TODO дописать методы для взаимодействия с пользователями


//    @GetMapping("/findByName")
//    public List<RecipeDto> findByName(@RequestParam String name) {
//        log.info("Handling find by name of the recipe request: " + name);
//        return recipeService.findByName(name);
//    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
//        log.info("Handling delete recipe request: " + id);
//        recipeService.deleteRecipe(id);
//        return ResponseEntity.ok().build();
//    }
}