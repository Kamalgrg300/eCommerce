package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Admin;
import com.kamal.eCommerce.model.User;
import com.kamal.eCommerce.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Register a new user
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.registerUser(user);
	}

	@PostMapping("/login") // Change this to @GetMapping if you want to allow GET
	public String login(@RequestBody User user) {
		User foundUser = userService.loginUser(user.getEmail(), user.getPassword());
		return (foundUser != null) ? "Login successful" : "Invalid credentials";
	}

     //register admin
	@PostMapping("/register-admin")
	public User registerAdmin(@RequestBody Admin admin) {
		return userService.registerAdmin(admin);
	}

	// Get all users
	@GetMapping
	public String getAllUsers(@RequestParam String email) {
		return userService.getAllUsers(email);
	}

	// Reset Password
	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String email, @RequestParam String newPassword) {
		return userService.resetPassword(email, newPassword);
	}

}
