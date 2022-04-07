package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AccountDTO {
	private int id;
	private String fullName;
	@NonNull
	private String username;
	@NonNull
	private String email;
	@NonNull
	private String departmentName;
	@NonNull
	private String positionName;

	@NonNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

}