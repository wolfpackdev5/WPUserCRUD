package com.wolfpack.User.service;

import com.wolfpack.User.model.User;
import com.wolfpack.User.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    //PARAMETERS
    private final UserRepo userRepo;

    //CONSTRUCTORS
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //METHODS
    //need to be able to save a user on cognito creation, feign client constructs user object to be saved
    public User newUser(User user) {
        this.userRepo.save(user);
        return user;
    }
    //set workout when given a workout from feign client
    public List assignWorkout(String email, List workout) {
        User user = this.userRepo.findByEmail(email);
        user.setWorkout(workout);
        return workout;
    }
    //retrieve user profile information to view or change
    public User userProfile(String email) {
        return this.userRepo.findByEmail(email);
    }
}
