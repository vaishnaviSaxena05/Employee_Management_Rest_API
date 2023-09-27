package com.gl.employeeManagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeeManagement.dto.RoleDto;
import com.gl.employeeManagement.model.Role;
import com.gl.employeeManagement.service.RoleService;

@RestController
@RequestMapping("/app")
public class RoleController {

	private RoleService roleService;

	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	// add roles --> admin access only
	// http://localhost:8080/app/addroles
	@PostMapping("/addroles")
	public Role addRole(@RequestBody RoleDto roleDto) {
		return roleService.saveRole(roleDto);
	}

}
