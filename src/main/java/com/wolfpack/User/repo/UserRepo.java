package com.wolfpack.User.repo;

import com.wolfpack.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}
