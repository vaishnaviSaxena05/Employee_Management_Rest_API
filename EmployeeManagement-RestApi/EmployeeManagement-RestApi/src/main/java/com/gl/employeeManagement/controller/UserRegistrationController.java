package com.gl.employeeManagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeeManagement.dto.UserRegistrationDto;
import com.gl.employeeManagement.model.User;
import com.gl.employeeManagement.service.UserService;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	// add new user
	// http://localhost:8080/registration/newuser
	@PostMapping("/newuser")
	public User registerUserAccount(@RequestBody UserRegistrationDto registrationDto) {
		return userService.save(registrationDto);

	}
}
