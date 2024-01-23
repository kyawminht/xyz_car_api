package com.A1.xyzcars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.A1.xyzcars.entity.User;
import com.A1.xyzcars.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Implement registration logic, e.g., validation, hashing passwords, etc.
        return userRepository.save(user);
    }

    @Override
    public List<User> searchUsers(String username) {
        // Implement search logic using userRepository
        if (username != null && !username.isEmpty()) {
            return userRepository.findByUsernameContaining(username);
        } else {
            return userRepository.findAll();
        }
    }

    @Override
    public long count() {
        // Implement the count logic using userRepository
        return userRepository.count();
    }

    @Override
    public void delete(User user) {
        // Delete a user by entity
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        // Delete a user by ID
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        // Get a user by ID
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(User updatedUser) {
        // Update a user
        return userRepository.save(updatedUser);
    }

    @Override
    public User loginUser(String username, String password) {
        
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null; // Login failed
        }
    }

}
