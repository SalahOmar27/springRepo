package com.salah.demo.mapper;

import org.mapstruct.Mapper;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;
@Mapper(componentModel = "spring")
public class DepartmentMapperImpl implements DepartmentMapper{

	@Override
	public DepartmentDto modelToDto(Department department) {
		DepartmentDto departmentDto= new DepartmentDto();
		departmentDto.setId(department.getDepartmentId());
		departmentDto.setName(department.getDepartmentName());
		return departmentDto;
	}

	@Override
	public Department dtoToModel(DepartmentDto departmentDto) {
		Department department = new Department();
		department.setDepartmentId(departmentDto.getId());
		department.setDepartmentName(departmentDto.getName());
		return department;
	}

}
