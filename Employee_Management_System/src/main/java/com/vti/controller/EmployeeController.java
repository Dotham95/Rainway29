package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.EmployeeDTO;
import com.vti.entity.Employee;
import com.vti.entity.fillter.EmployeeFilter;
import com.vti.service.IEmployeeService;

@RestController
@RequestMapping("/v1/api/employees")
//@CrossOrigin("*")
@Validated
public class EmployeeController {
	@Autowired
	IEmployeeService emService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public Page<EmployeeDTO> getAllEmployees(Pageable pageable,
			@RequestParam(value = "search", required = false) String search, EmployeeFilter filter) {
		Page<Employee> entityPages = emService.getAll(pageable, search, filter);
		List<EmployeeDTO> listEmployeeDTOs = modelMapper.map(entityPages.getContent(),
				new TypeToken<List<EmployeeDTO>>() {
				}.getType());
		Page<EmployeeDTO> pageEmployeeDTO = new PageImpl<>(listEmployeeDTOs, pageable, entityPages.getTotalElements());
		return pageEmployeeDTO;
	}
}
