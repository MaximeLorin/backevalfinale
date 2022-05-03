package com.zenika.academy.barbajavas.backFinalProject.web;

import com.zenika.academy.barbajavas.backFinalProject.domain.application.UserService;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.createUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody createUserDTO userDTO){
        User user=userService.newUser(userDTO.email(),userDTO.password(),userDTO.username());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("/users/{username}")
    ResponseEntity<User> getByUsername(@PathVariable String username){
        return userService.getUserByUsername(username).map(u -> ResponseEntity.ok(u)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
