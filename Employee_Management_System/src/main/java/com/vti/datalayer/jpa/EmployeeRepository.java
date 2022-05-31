package com.vti.datalayer.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Employee;

public interface EmployeeRepository {

	public Page<Employee> findAll(Specification<Employee> emSpecification, Pageable pageable);

	public Employee findByUsername(String username);

}
