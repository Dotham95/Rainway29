package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Employee;
import com.vti.entity.fillter.EmployeeFilter;

public interface IEmployeeService extends UserDetailsService {

	public Page<Employee> getAll(Pageable pageable, String search, EmployeeFilter filter);

}
