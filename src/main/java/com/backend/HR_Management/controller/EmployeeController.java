package com.backend.HR_Management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.HR_Management.entity.Employee;
import com.backend.HR_Management.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/{deptId}")
	public Employee create(@RequestBody Employee emp, @PathVariable Long deptId) {
		return employeeService.createEmployee(emp, deptId);
	}

	@GetMapping
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return employeeService.getById(id);
	}
	@GetMapping("/getbyName/{name}")
	public List<Employee> findByName(@PathVariable String name){
		return employeeService.findByName(name);
	}
	@GetMapping("/getByEmail/{email}")
	public Optional<Employee> findByEmail(@PathVariable String email) {
		return employeeService.findByEmail(email);
	}
	@GetMapping("/getbByPhone/{phone}")
	public Optional<Employee> findByPhone(@PathVariable String phone) {
		return employeeService.findByPhone(phone);
	}

	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
		return employeeService.updateEmployee(id, emp);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully!";
	}

}
