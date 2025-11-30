package com.backend.HR_Management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.HR_Management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> getByName(String name);
	Optional<Employee> getByPhone(String phone);
	Optional<Employee> getByEmail(String email);
}
