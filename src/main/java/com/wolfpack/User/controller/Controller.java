package com.wolfpack.User.controller;

import com.wolfpack.User.model.User;
import com.wolfpack.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Controller {

    //PARAMETERS
    @Autowired
    private final UserService userService;

    //CONSTRUCTOR
    public Controller(UserService userService) {
        this.userService = userService;
    }

    //METHOD
    @GetMapping("/profile")
    public ResponseEntity<User> getUserInfo(@RequestBody String email) {
        User client = this.userService.userProfile(email);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/welcome")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        User client = this.userService.newUser(user);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
    @PutMapping("/newWorkout")
    public ResponseEntity<List> newWorkout(@RequestBody String email, @RequestBody List workout) {
        List exercises = this.userService.assignWorkout(email, workout);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
