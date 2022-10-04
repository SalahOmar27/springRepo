package com.salah.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	//@Mapping(source = "id", target = "department.departmentId")
	//@Mapping(source = "name", target = "department.departmentName")
	DepartmentDto modelToDto(Department department);

	Department dtoToModel(DepartmentDto departmentDto);
	
	//List<DepartmentDto> modelToDtos(List<Department> departments);
}
 