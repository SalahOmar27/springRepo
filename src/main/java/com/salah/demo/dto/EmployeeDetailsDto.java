package com.salah.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDetailsDto {
	private long employeeId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private int salary;
	private long departmentId;

}
