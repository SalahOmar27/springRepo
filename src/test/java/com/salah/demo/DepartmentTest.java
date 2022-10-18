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

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.mapper.DepartmentMapper;
import com.salah.demo.mapper.DepartmentMapperImpl;
import com.salah.demo.model.Department;
import com.salah.demo.repository.DepartmentRepository;
import com.salah.demo.service.DepartmentService;

@SpringBootTest
class DepartmentTest {

	@Mock
	private DepartmentRepository departmentRepository;

	@Mock
	private DepartmentService departmentService;
	@Mock
	private DepartmentMapper departmentMapper;
	@Mock
	private DepartmentMapperImpl departmentMapperImpl;

	@BeforeAll
	public static void setUp() {
		DepartmentDto dto = new DepartmentDto();
		dto.setId(1);
		dto.setName("HR");

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

		DepartmentDto departmentDto = null;
		Department result = departmentService.addDepartment(departmentDto);

		assertThat(departmentService.addDepartment(departmentDto)).isEqualTo(result);

	}

	@Test
	public void getAllDepartment() {

		List<DepartmentDto> departmentDtos = null;

		Mockito.when(
				departmentRepository.findAll()
				.stream().map(departmentMapper::modelToDto)
				.collect(Collectors.toList()))
				.thenReturn(departmentDtos);

	}

}
