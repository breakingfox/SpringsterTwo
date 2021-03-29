package com.example.SpringsterTwo.service.security;

import com.example.SpringsterTwo.dto.UserDto;
import com.example.SpringsterTwo.entity.users.User;
import com.example.SpringsterTwo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("userDetailsServiceImpl")
public class UserDefaultServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromUser).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(user);
    }
//    public UserDetails loadUserByLogin(String login) throws UsernameNotFoundException {
//        User user = userRepository.findByLogin(login).orElseThrow(() ->
//                new UsernameNotFoundException("User doesn't exists"));
//        return SecurityUser.fromUser(user);
//    }
}
