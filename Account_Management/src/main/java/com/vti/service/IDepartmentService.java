package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.filter.DepartmentFilter;
import com.vti.entity.form.DepartmentForm;

public interface IDepartmentService extends UserDetailsService {
	public Page<Department> getAll(Pageable pageable, DepartmentFilter filter);

	public Account getDepartmentByID(int id);

	public Account getDepartmentByName(String name);

	public Account updateDepartment(int id, DepartmentForm form);

	public Account createDepartment(DepartmentForm form);

	public void deleteDepartment(int id);

	public void deleteDepartments(List<Integer> ids);
}
