package com.A1.xyzcars.service;

import java.util.List;
import java.util.Optional;

import com.A1.xyzcars.entity.Car;
import com.A1.xyzcars.entity.User;

public interface UserService {
    User registerUser(User user);

    List<User> searchUsers(String username);
   
    
    User loginUser(String username, String password);
    
    long count();

    void delete(User user);

    void deleteUserById(Long userId);

    Optional<User> getUserById(Long userId);

    User updateUser(User updatedUser);
}
