package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Admin;
import com.kamal.eCommerce.model.User;
import com.kamal.eCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for user operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Register a new user.
     */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    /**
     * User login.
     */
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.loginUser(user.getEmail(), user.getPassword());
    }

    /**
     * Register an admin.
     */
    @PostMapping("/register-admin")
    public User registerAdmin(@RequestBody Admin admin) {
        return userService.registerAdmin(admin);
    }

    /**
     * Get all users (Admin only).
     */
    @GetMapping
    public List<User> getAllUsers(@RequestParam String email) {
        return userService.getAllUsers(email);
    }

    /**
     * Reset a user's password.
     */
    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        return userService.resetPassword(email, newPassword);
    }
}
