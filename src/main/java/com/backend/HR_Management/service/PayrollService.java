package com.backend.HR_Management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.HR_Management.entity.Employee;
import com.backend.HR_Management.entity.Payroll;
import com.backend.HR_Management.repository.EmployeeRepository;
import com.backend.HR_Management.repository.PayrollRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PayrollService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PayrollRepository payrollRepository;

	public Payroll generatePayroll(Long empId) {
		Employee emp = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
		double basic = emp.getBasicSalary();
		double hra = basic * 0.20;
		double pf = basic * 0.12;
		double gross = basic + hra;
		double net = gross - pf;

		Payroll p = new Payroll();
		p.setEmployeeId(emp.getId());
		p.setBasicSalary(basic);
		p.setHra(hra);
		p.setPf(pf);
		p.setGrossSalary(gross);
		p.setNetSalary(net);
		p.setPayrollDate(LocalDate.now());

		return payrollRepository.save(p);
	}

	public List<Payroll> getAll() {
		return payrollRepository.findAll();
	}

	public Payroll getById(Long id) {
		return payrollRepository.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
	}

	public void deletePayroll(Long id) {
		payrollRepository.deleteById(id);
	}
}
