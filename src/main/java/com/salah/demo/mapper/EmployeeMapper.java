package com.salah.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	@Mapping(source = "employeeId", target = "id")
	//@Mapping(source = "department", target = "departmentId")
	EmployeeDto modelToDto(Employee employee);

	@Mapping(source = "id",target = "employeeId")
	Employee dtoToModel(EmployeeDto employeeDto);

}