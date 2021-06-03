package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.users.Role;
import com.example.SpringsterTwo.entity.users.Status;
import com.example.SpringsterTwo.entity.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {
    private Long id;
    private String password;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;
}
