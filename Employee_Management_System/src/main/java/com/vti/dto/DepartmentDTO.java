package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	private int id;
	
	public String name;
	
	private int totalMember;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
}
