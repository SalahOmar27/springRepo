package com.salah.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.mapper.EmployeeMapper;
import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = employeeMapper.dtoToModel(employeeDto);
		employee = employeeRepository.save(employee);
		return employeeMapper.modelToDto(employee);

	}

	public List<EmployeeDto> getAllEmployee() {
		return employeeRepository.findAll().stream().map(employeeMapper::modelToDto).collect(Collectors.toList());
	}

}
