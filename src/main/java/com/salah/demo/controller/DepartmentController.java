package com.salah.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.service.DepartmentService;

@RestController
@Validated
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/addDepartments")
	public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto) {
		return departmentService.addDepartment(departmentDto);

	}

	@GetMapping("/getAllDepartment")
	public List<DepartmentDto> getAllDepartment() {
		return departmentService.getAllDepartment();

	}
}
