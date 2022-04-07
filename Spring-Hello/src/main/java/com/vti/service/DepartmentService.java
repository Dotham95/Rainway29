package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.datalayer.jpa.DepartmentRepository;
import com.vti.entity.Department;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getDepartments() {

		return departmentRepository.findAll();
	}

}
