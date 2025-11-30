package com.backend.HR_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.HR_Management.entity.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
