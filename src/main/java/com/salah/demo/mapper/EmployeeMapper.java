package com.salah.demo.mapper;

import org.mapstruct.Mapper;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	EmployeeDto modelToDto(Employee employee);

	Employee dtoToModel(EmployeeDto employeeDto);

} 