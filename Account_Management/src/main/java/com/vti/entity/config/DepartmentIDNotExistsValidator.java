package com.vti.entity.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.datalayer.DepartmentRepository;

public class DepartmentIDNotExistsValidator implements ConstraintValidator<DepartmentNotExists, Integer> {

	@Autowired
	DepartmentRepository repository;

	//check neu DepartmentID co torng database thi return true
	// khong co thi return false
	@Override
	public boolean isValid(Integer departmentID, ConstraintValidatorContext context) {
		
		return repository.existsById(departmentID);
	}

}
