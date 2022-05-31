package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
	private String employee_code;
	
	private String fullName;

	private String username;

	private String departmentName;
	
	private String positionName;
	
	private String contract;

}
