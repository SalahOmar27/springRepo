package com.salah.demo.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	// @NonNull

	private String name;

}
