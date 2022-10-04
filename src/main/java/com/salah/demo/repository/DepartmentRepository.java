package com.salah.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salah.demo.dto.DepartmentDto;
import com.salah.demo.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	DepartmentDto save(DepartmentDto departmentDto);

}
