package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.service.DepartmentService;

@RestController
@RequestMapping("/v1/api/departments")
@CrossOrigin("*")
public class DepartmnetController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public List<DepartmentDTO> getAll() {
		List<Department> departments = departmentService.getDepartments();
		List<DepartmentDTO> dtos = modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>() {
		}.getType());
		return dtos;
	}
}
