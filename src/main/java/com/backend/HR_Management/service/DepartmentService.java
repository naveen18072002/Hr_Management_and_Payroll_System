package com.backend.HR_Management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.HR_Management.entity.Department;
import com.backend.HR_Management.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department createDepartment(Department d) {
		return departmentRepository.save(d);
	}

	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	public Department getById(Long id) {
		return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department Not Found"));
	}
	public Optional<Department> getDepartment(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}

	public Department updateDepartment(Long id, Department newDept) {
		Department dept = getById(id);
		dept.setDepartmentName(newDept.getDepartmentName());
		dept.setLocation(newDept.getLocation());
		return departmentRepository.save(dept);
	}

	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
}
