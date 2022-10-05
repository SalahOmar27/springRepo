package com.salah.demo.mapper;

import org.mapstruct.Mapper;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;
@Mapper(componentModel = "spring")
public class EmployeeMapperImpl implements EmployeeMapper {

	@Override
	public EmployeeDto modelToDto(Employee employee) {

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		employeeDto.setPhone(employee.getPhone());
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setDepartmentId(employee.getDepartment().getDepartmentId());
		return employeeDto;
	}

	@Override
	public Employee dtoToModel(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhone(employeeDto.getPhone());
		employee.setSalary(employeeDto.getSalary());
	//	employee.setDepartment(employeeDto.getDepartmentId());
		return employee;
	}

}
