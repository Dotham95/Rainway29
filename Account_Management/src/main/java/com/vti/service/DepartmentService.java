package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.datalayer.DepartmentRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.filter.DepartmentFilter;
import com.vti.entity.form.DepartmentForm;
import com.vti.specification.DepartmentSpecification;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ModelMapper modelMapper;

	public DepartmentService() {

	}

	public Page<Department> getAll(Pageable pageable, DepartmentFilter fillter) {
		Specification<Department> deSpecification = DepartmentSpecification.builWhere(fillter);
		return departmentRepository.findAll(deSpecification, pageable);
	}

	public Department getDepartmentByID(int id) {
		return departmentRepository.findById(id).get();
	}

	public Department getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	public Department createDepartment(DepartmentForm form) {
		Department department2 = new Department();
		department2.setName(form.getName());
		return departmentRepository.save(department2);
	}

	public Department updateDepartment(int id, DepartmentForm form) {
		Department department = departmentRepository.findById(id).get();
		department.setName(form.getName());
		return departmentRepository.save(department);
	}

	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}

	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
	}

	public void deleteDepartments(List<Integer> ids) {
		departmentRepository.deleteByIds(ids);
	}
}
