package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Department;

public class CustomDepartmentSpecification implements  Specification<Department> {
	private String key;
	private String value;

	public CustomDepartmentSpecification(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if ("departmentName".equals(key)) {
			return criteriaBuilder.like(root.get("departmentName"), "%" + value + "%");
		}
		return null;
	}

}

