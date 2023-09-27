package com.gl.employeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeManagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByfirstNameContainsAllIgnoreCase(String firstName);
}