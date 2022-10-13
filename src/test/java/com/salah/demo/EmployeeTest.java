package com.salah.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Department;
import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;
import com.salah.demo.service.EmployeeService;

class EmployeeTest {
	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	static Employee employee;
	static EmployeeDto employeeDto;

	@SuppressWarnings("static-access")
	@BeforeAll
	public static void setUp() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(1);
		employeeDto.setFirstName("salah");
		employeeDto.setLastName("salah");
		employeeDto.setEmail("salah@gmail.com");
		employeeDto.setPhone("0788567568");
		employeeDto.setSalary(2700);
		employeeDto.setDepartment(new Department().builder().departmentId(1).build());

		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("salah");
		employee.setLastName("salah");
		employee.setEmail("salah@gmail.com");
		employee.setPhone("0788567568");
		employee.setSalary(2700);
		employee.setDepartment(new Department().builder().departmentId(1).build());

	}

	@Test
	public void addDepartment() {

		when(employeeRepository.save(any(EmployeeDto.class))).thenAnswer(i -> {
			Employee employee = i.getArgument(0);
			employee.setEmployeeId(1);
			return employee;
		});

		EmployeeDto employee1 = employeeService.addEmployee(employeeDto);

		// ArgumentCaptor<Employee> argumentCaptor =
		// ArgumentCaptor.forClass(Employee.class);

		// verify(employeeRepository.save(argumentCaptor.capture()));

		assertEquals(employee1, employeeDto);
	}

	@Test
	public void getAllEmployee() {

		List<Employee> employees = new ArrayList<>();
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);

	}

}
