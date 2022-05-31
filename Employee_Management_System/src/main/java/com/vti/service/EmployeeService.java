package com.vti.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vti.datalayer.jpa.EmployeeRepository;
import com.vti.entity.Employee;
import com.vti.entity.fillter.EmployeeFilter;
import com.vti.specification.EmployeeSpecifition;

public class EmployeeService implements IEmployeeService {
	@Autowired
	EmployeeRepository emRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Page<Employee> getAll(Pageable pageable, String search, EmployeeFilter filter) {
		Specification<Employee> emSpecification = EmployeeSpecifition.builWhere(search, filter);
		return emRepository.findAll(emSpecification, pageable);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = emRepository.findByUsername(username);
		if (employee == null) {
			throw new UsernameNotFoundException("Không tìm thấy employee");
		}
		return new User(employee.getUsername(), employee.getPassword(),
				AuthorityUtils.createAuthorityList(employee.getRole().toString()));
	}
}
