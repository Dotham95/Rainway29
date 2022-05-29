package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
	private int id;
	private String fullName;

	private String username;

	private String role;
	private String email;

	private String departmentName;
//
	private String positionName;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

}
