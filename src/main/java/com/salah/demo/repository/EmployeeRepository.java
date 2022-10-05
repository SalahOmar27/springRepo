package com.salah.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salah.demo.dto.EmployeeDto;
import com.salah.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	EmployeeDto save(EmployeeDto employeeDto);

}
