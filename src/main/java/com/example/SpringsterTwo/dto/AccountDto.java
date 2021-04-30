package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.users.Role;
import com.example.SpringsterTwo.entity.users.Status;

public class AccountDto {
    //TODO класс для передачи данных со страницы регистрации в юзера
    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;
}
