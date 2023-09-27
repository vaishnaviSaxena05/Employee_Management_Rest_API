package com.gl.employeeManagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.gl.employeeManagement.dto.UserRegistrationDto;
import com.gl.employeeManagement.model.User;

@Service
public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
}
