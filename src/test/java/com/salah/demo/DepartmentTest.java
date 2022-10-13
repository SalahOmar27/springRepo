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
import org.springframework.boot.test.context.SpringBootTest;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;
import com.salah.demo.repository.DepartmentRepository;
import com.salah.demo.service.DepartmentService;

@SpringBootTest
class DepartmentTest {

	@Mock
	private DepartmentRepository departmentRepository;

	@InjectMocks
	private DepartmentService departmentService;

	static DepartmentDto departmentDto;
	static Department department;;

	@BeforeAll
	public static void setUp() {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(1);
		departmentDto.setName("HR");

		Department department = new Department();
		department.setDepartmentId(1);
		department.setDepartmentName("HR");

	}

	@Test
	public void addDepartment() {

		when(departmentRepository.save(any(Department.class))).thenAnswer(i -> {
			Department department = i.getArgument(0);
			department.setDepartmentId(1);
			return department;
		});

		DepartmentDto department1 = departmentService.addDepartment(departmentDto);
		;
		// ArgumentCaptor<Department> argumentCaptor =
		// ArgumentCaptor.forClass(Department.class);
		assertEquals(department1, department);

	}

	@Test
	public void getAllDepartment() {

		List<Department> departmentDtos = new ArrayList<>();
		Mockito.when(departmentRepository.findAll()).thenReturn(departmentDtos);

	}

}
