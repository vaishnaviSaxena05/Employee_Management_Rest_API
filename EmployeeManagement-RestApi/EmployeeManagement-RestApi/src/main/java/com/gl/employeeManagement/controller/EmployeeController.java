package com.gl.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeeManagement.model.Employee;
import com.gl.employeeManagement.repository.EmployeeRepository;
import com.gl.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@Autowired
	EmployeeRepository employeeRepository;

	// Add new employee --> admin access only
	// http://localhost:8080/api/addEmployee
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// get all existing employees --> admin, user access
	// http://localhost:8080/api/getAllEmployees
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// get employee by id--> admin, user access
	// http://localhost:8080/api/getEmployeeById/1
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	// update existing employee --> admin access only
	// http://localhost:8080/api/updateEmployee/2
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	// delete existing employee by id --> admin access only
	// http://localhost:8080/api/deleteEmployeeById/4
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

	// search an existing employee by its first name --> admin, user access
	// http://localhost:8080/api/search?firstName=ja
	@GetMapping("/search")
	public List<Employee> searchByFirstName(@RequestParam("firstName") String firstName) {
		return employeeRepository.findByfirstNameContainsAllIgnoreCase(firstName);
	}

	// sort existing employees by name --> admin, user access
	// http://localhost:8080/api/sortByName?order=ASC
	@GetMapping("/sortByName")
	public List<Employee> sortByName(Direction order) {
		return employeeService.SortByName(order);
	}

}