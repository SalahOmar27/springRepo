package com.salah.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployee(employeeDto);

	}

	@GetMapping("/getAllEmployee")
	public List<EmployeeDto> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
}
