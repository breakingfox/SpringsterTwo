package com.example.SpringsterTwo.service.user;

import com.example.SpringsterTwo.dto.RegistrationDto;
import com.example.SpringsterTwo.entity.users.User;
import com.example.SpringsterTwo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;


    @Override
    public RegistrationDto saveUser(RegistrationDto registrationDto) {
        User user = userRepository.saveAndFlush(userConverter.fromRegistration(registrationDto));
        return userConverter.toRegistration(user);
    }
}
