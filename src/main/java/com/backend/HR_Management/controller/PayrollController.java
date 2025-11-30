package com.backend.HR_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.HR_Management.entity.Payroll;
import com.backend.HR_Management.service.PayrollService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payroll")
@RequiredArgsConstructor
public class PayrollController {
	@Autowired
	private PayrollService payrollService;
	
	 @PostMapping("/generate/{empId}")
	    public Payroll generate(@PathVariable Long empId) {
	        return payrollService.generatePayroll(empId);
	    }

	    @GetMapping
	    public List<Payroll> getAll() {
	        return payrollService.getAll();
	    }

	    @GetMapping("/{id}")
	    public Payroll getById(@PathVariable Long id) {
	        return payrollService.getById(id);
	    }

	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Long id) {
	        payrollService.deletePayroll(id);
	        return "Payroll record deleted!";
	    }
	
}
