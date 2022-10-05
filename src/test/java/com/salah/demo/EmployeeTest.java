package com.salah.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;
import com.salah.demo.service.EmployeeService;

class EmployeeTest {
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	@BeforeAll
	public static void setUp() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(1);
		employeeDto.setFirstName("salah");
		employeeDto.setLastName("salah");
		employeeDto.setEmail("salah@gmail.com");
		employeeDto.setPhone("0788567568");
		employeeDto.setSalary(2700);
		employeeDto.setDepartmentId(1);

		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("salah");
		employee.setLastName("salah");
		employee.setEmail("salah@gmail.com");
		employee.setPhone("0788567568");
		employee.setSalary(2700);
		employee.setDepartment(null);

	}

	@Test
	public void addDepartment() {

		when(employeeRepository.save(any(EmployeeDto.class))).thenAnswer(i -> {
			DepartmentDto departmentDto = i.getArgument(0);
			departmentDto.setId(1);
			return departmentDto;
		});

		ArgumentCaptor<Employee> argumentCaptor = ArgumentCaptor.forClass(Employee.class);

		verify(employeeRepository.save(argumentCaptor.capture()));
	}

	@Test
	public void getAllEmployee() {

		List<Employee> employees = new ArrayList<>();
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);

	}

}
