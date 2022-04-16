package com.vti.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	public String name;

	public List<AccountDTO> accounts;

}
