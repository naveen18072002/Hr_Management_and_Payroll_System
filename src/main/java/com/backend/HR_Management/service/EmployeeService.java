package com.backend.HR_Management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.HR_Management.entity.Department;
import com.backend.HR_Management.entity.Employee;
import com.backend.HR_Management.repository.DepartmentRepository;
import com.backend.HR_Management.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public Employee createEmployee(Employee emp, Long deptId) {
		Department dept = departmentRepository.findById(deptId)
				.orElseThrow(() -> new RuntimeException("Department not found"));
		emp.setDepartment(dept);
		return employeeRepository.save(emp);
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee getById(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	public List<Employee> findByName(String name) {
		return employeeRepository.getByName(name);
	}

	public Optional<Employee> findByEmail(String email) {
		return employeeRepository.getByEmail(email);
	}

	public Optional<Employee> findByPhone(String phone) {
		return employeeRepository.getByPhone(phone);
	}

	public Employee updateEmployee(Long id, Employee newEmp) {
		Employee emp = getById(id);
		emp.setName(newEmp.getName());
		emp.setEmail(newEmp.getEmail());
		emp.setPhone(newEmp.getPhone());
		emp.setDesignation(newEmp.getDesignation());
		emp.setBasicSalary(newEmp.getBasicSalary());
		return employeeRepository.save(emp);
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
