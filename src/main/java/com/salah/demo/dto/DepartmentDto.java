package com.salah.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentDto {
	public DepartmentDto(String string) {
		// TODO Auto-generated constructor stub
	}
	private long id;
	@NonNull
	private String name;

}
