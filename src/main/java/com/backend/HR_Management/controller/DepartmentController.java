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

import com.backend.HR_Management.entity.Department;
import com.backend.HR_Management.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public Department create(@RequestBody Department dept) {
		return departmentService.createDepartment(dept);
	}

	@GetMapping
	public List<Department> getAll() {
		return departmentService.getAll();
	}

	@GetMapping("/{id}")
	public Department getById(@PathVariable Long id) {
		return departmentService.getById(id);
	}
	@GetMapping("/getDepartment/{departmentName}")
	public Optional<Department> getDepartment(@PathVariable String departmentName) {
		return departmentService.getDepartment(departmentName);
	}

	@PutMapping("/{id}")
	public Department update(@PathVariable Long id, @RequestBody Department dept) {
		return departmentService.updateDepartment(id, dept);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return "Department deleted successfully!";
	}

}
