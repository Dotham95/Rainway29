package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
	private int id;
	private String fullName;

	private String username;

	private String email;

	private String departmentName;

	private String positionName;

	private String role;

	private String password;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

}