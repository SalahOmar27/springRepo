package com.salah.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.mapper.EmployeeMapper;
import com.salah.demo.mapper.EmployeeMapperImpl;
import com.salah.demo.model.Department;
import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;
import com.salah.demo.service.EmployeeService;

@SpringBootTest
class EmployeeTest {
	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private EmployeeService employeeService;

	@Mock
	private EmployeeMapper employeeMapper;

	@Mock
	private EmployeeMapperImpl employeeMapperImpl;

	
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

		EmployeeDto employeeDto = null;
		Employee result = employeeService.addEmployee(employeeDto);
		assertThat(employeeService.addEmployee(employeeDto)).isEqualTo(result);

	}

	@Test
	public void getAllEmployee() {

		List<EmployeeDto> employees = null;
		Mockito.when(employeeRepository.findAll()
				.stream()
				.map(employeeMapper::modelToDto)
				.collect(Collectors.toList()))
				.thenReturn(employees);

	}

}
