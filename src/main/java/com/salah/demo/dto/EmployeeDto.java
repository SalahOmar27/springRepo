package com.salah.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private long salary;
	private long departmentId;

}
