package com.salah.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	
	 DepartmentMapper INSTANCE = Mappers.getMapper( DepartmentMapper.class );

	@Mapping(source = "departmentId", target = "id")
	@Mapping(source = "departmentName", target = "name")
	DepartmentDto modelToDto(Department department);

	@Mapping(source = "id", target = "departmentId")
	@Mapping(source = "name", target = "departmentName")
	Department dtoToModel(DepartmentDto departmentDto);

}
 