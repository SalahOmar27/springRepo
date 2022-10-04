package com.salah.demo;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salah.demo.model.Department;
import com.salah.demo.repository.DepartmentRepository;
import com.salah.demo.service.DepartmentService;

@SpringBootTest
class DepartmentTest {

	@Mock
	@Autowired
	private DepartmentRepository departmentRepository;

	private AutoCloseable autoCloseable;
	@Mock
	@Autowired
	private DepartmentService departmentService;

	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		departmentService = new DepartmentService(departmentRepository);
		

	}

	@Test
	public void addDepartment() {
		// given
		Department department = new Department("HR");
		// when
		departmentService.addDepartment(department);
		// then
		ArgumentCaptor<Department> argumentCaptor = ArgumentCaptor.forClass(Department.class);

		verify(departmentRepository.save(argumentCaptor.capture()));
	}

	@Test
	public void getAllDepartment() {

		List<Department> departmentDtos = new ArrayList<>();
		Mockito.when(departmentRepository.findAll()).thenReturn(departmentDtos);

	}

}
