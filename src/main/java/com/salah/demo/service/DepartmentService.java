package com.salah.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.mapper.DepartmentMapperImpl;
import com.salah.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	DepartmentMapperImpl departmentMapperImpl;

	public DepartmentService(DepartmentRepository departmentRepository2) {
		// TODO Auto-generated constructor stub
	}

	public DepartmentDto addDepartment(DepartmentDto departmentDto) {
		return departmentRepository.save(departmentDto);

	}

	public List<DepartmentDto> getAllDepartment() {
		return departmentRepository.findAll().stream().map(departmentMapperImpl::modelToDto).collect(Collectors.toList());
	}

}
