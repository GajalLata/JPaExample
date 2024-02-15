package com.jpaexample.BootJpaExample.controller;

import com.jpaexample.BootJpaExample.model.User;
import com.jpaexample.BootJpaExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{userId}")
    private ResponseEntity<User> getUserById(@PathVariable int userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }


    @GetMapping
    private  ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
    }


    @PostMapping
    private ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data added successfuuly");
    }

    @DeleteMapping("/{userId}")
    private ResponseEntity<String> deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data deleted successfuuly");
    }

    @PutMapping("/{userId}")
    private ResponseEntity<String> updateUser(@PathVariable int userId,@RequestBody User updatedUser){
        userService.updateUser(userId, updatedUser);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data updated successfuuly");
    }
}
