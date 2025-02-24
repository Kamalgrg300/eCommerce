package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.Admin;
import com.kamal.eCommerce.model.User;
import com.kamal.eCommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for handling user operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Register a new user.
     */
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    /**
     * User login.
     */
    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return "Invalid credentials";
        }
        return "Login successful";
    }

    /**
     * Register an admin.
     */
    public User registerAdmin(Admin admin) {
        return userRepository.save(admin);
    }

    /**
     * Get all users (admin only).
     */
    public List<User> getAllUsers(String email) {
        User user = userRepository.findByEmail(email);
        if (user instanceof Admin) {
            return userRepository.findAll();
        }
        throw new RuntimeException("Access denied. Only admins can view users.");
    }

    /**
     * Reset password for a user.
     */
    public String resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return "Password updated successfully";
        }
        return "User not found";
    }
}
