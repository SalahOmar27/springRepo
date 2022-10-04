package com.salah.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.mapper.DepartmentMapper;
import com.salah.demo.model.Department;
import com.salah.demo.repository.DepartmentRepository;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public DepartmentService(DepartmentRepository departmentRepository2) {
		// TODO Auto-generated constructor stub
	}

	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
		
	}
	
	public List<DepartmentDto> getAllDepartment() {
		return departmentRepository.findAll().stream().map(departmentMapper::modelToDto)
				.collect(Collectors.toList());
	}

}
