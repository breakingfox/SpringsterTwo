package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.RegistrationDto;
import com.example.SpringsterTwo.entity.users.Role;
import com.example.SpringsterTwo.entity.users.Status;
import com.example.SpringsterTwo.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
@Log
public class RegistrationController {
    UserService userService;
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/")
    public RegistrationDto registration(@RequestBody RegistrationDto registrationDto) {
        registrationDto.setStatus(Status.ACTIVE);
        registrationDto.setRole(Role.USER);
        registrationDto.setPassword(new BCryptPasswordEncoder(12).encode(registrationDto.getPassword()));
        return userService.saveUser(registrationDto);
    }
}
