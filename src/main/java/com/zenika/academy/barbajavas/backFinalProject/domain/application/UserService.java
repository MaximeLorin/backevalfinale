package com.zenika.academy.barbajavas.backFinalProject.domain.application;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import com.zenika.academy.barbajavas.backFinalProject.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    public UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User newUser(String username, String password, String email){
        boolean admin=false;
        User user = new User(UUID.randomUUID().toString(),admin,username,passwordEncoder.encode(password),email);
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUser(){return (List<User>) userRepository.findAll();}
}
