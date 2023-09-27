package com.gl.employeeManagement.serviceImpl;

import org.springframework.stereotype.Service;

import com.gl.employeeManagement.dto.RoleDto;
import com.gl.employeeManagement.model.Role;
import com.gl.employeeManagement.repository.RoleRepository;
import com.gl.employeeManagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role saveRole(RoleDto roleDto) {
		Role role = new Role(roleDto.getName());
		return roleRepository.save(role);
	}

}
