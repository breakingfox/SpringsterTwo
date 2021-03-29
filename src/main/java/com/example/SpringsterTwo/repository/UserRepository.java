package com.example.SpringsterTwo.repository;

import com.example.SpringsterTwo.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
//позволяем ввести в любой
    Optional<User> findByUsernameIgnoreCase(String username);

    List<User> findAll();

    void deleteByEmail(String email);
}
