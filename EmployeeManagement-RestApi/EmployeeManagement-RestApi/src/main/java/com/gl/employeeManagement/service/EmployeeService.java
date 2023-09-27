package com.gl.employeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.employeeManagement.model.Employee;

@Service
public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);

	List<Employee> SortByName(Direction direction);

	List<Employee> searchByFirstName(String name);

}
