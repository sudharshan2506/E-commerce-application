package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userservice.registerNewUser(user);
    }
	@PostConstruct
	public void initRolesandUsers() {
		userservice.initolesandurser();
	}
	@GetMapping({"/forAdmins"})
	public String forAdmin() {
		return "For admins only";
	}
	@GetMapping({"/forUsers"})
	public String forUser() {
		return "For users only";
	
	}
}

