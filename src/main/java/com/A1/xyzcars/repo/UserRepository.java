package com.A1.xyzcars.repo;

import com.A1.xyzcars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	  List<User> findByUsernameContaining(String username);
	    User findByUsername(String username);
    // Add other custom query methods if needed

    // Additional methods for CRUD operations
    void deleteById(Long userId);
    
    // Custom method for updating a user's username by ID
    @Modifying
    @Query("UPDATE User u SET u.username = :newUsername WHERE u.id = :userId")
    void updateUsernameById(Long userId, String newUsername);
}
