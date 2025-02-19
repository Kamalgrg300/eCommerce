package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.Admin;
import com.kamal.eCommerce.model.User;
import com.kamal.eCommerce.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a user
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // User login
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    //register admin
    public User registerAdmin(Admin admin) {
        return userRepository.save(admin);
    }

    
    //fetching can de done only by admin.
    //admin can only view
    public String getAllUsers(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null && user instanceof Admin) {
            List<User> users = userRepository.findAll();
            return users.toString();
        }
        return "Access denied. Only admin can view users.";
    }

   
    
    
 // Reset Password
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
