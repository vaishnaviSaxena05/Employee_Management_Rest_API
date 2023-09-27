package com.gl.employeeManagement.service;

import org.springframework.stereotype.Service;

import com.gl.employeeManagement.dto.RoleDto;
import com.gl.employeeManagement.model.Role;

@Service
public interface RoleService {

	Role saveRole(RoleDto roleDto);

}
