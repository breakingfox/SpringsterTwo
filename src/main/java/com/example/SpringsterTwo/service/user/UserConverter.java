package com.example.SpringsterTwo.service.user;

import com.example.SpringsterTwo.dto.RegistrationDto;
import com.example.SpringsterTwo.entity.users.Role;
import com.example.SpringsterTwo.entity.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConverter {
    public User fromRegistration(RegistrationDto registrationDto) {
        return User.builder().email(registrationDto.getEmail())
                .firstName(registrationDto.getFirstName())
                .id(registrationDto.getId())
                .lastName(registrationDto.getLastName())
                .password(registrationDto.getPassword())
                .role(registrationDto.getRole())
                .status(registrationDto.getStatus())
                .username(registrationDto.getUsername())
                .build();
    }

    public RegistrationDto toRegistration(User user) {
        return RegistrationDto.builder().email(user.getEmail()).
                firstName(user.getFirstName()).
                id(user.getId()).
                lastName(user.getLastName()).
                password(user.getPassword()).
                role(user.getRole()).
                status(user.getStatus()).
                build();
    }
}
