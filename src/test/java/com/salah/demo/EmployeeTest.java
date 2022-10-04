package com.salah.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.salah.demo.model.Employee;
import com.salah.demo.repository.EmployeeRepository;
import com.salah.demo.service.EmployeeService;

class EmployeeTest {
	@Mock
	private EmployeeRepository employeeRepository;
	
	private AutoCloseable autoCloseable;
	private EmployeeService employeeService;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		employeeService = new EmployeeService();

	}

	@Test
	public void addDepartment() {
		// given
		Employee employee = new Employee(1, "salah", "omar", "0788567568", "salah@gmail.com", 2700, null);
		// when
		employeeService.addEmployee(employee);
		// then
		ArgumentCaptor<Employee> argumentCaptor = ArgumentCaptor.forClass(Employee.class);

		verify(employeeRepository.save(argumentCaptor.capture()));
	}

	@Test
	public void getAllEmployee() {

		List<Employee> employees = new ArrayList<>();
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);

	}
	
}
