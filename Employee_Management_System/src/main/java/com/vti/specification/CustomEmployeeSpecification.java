package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Employee;

public class CustomEmployeeSpecification implements Specification<Employee> {
	private String key;
	private String value;

	public CustomEmployeeSpecification(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if ("email".equals(key)) {
			return criteriaBuilder.like(root.get("email"), "%" + value + "%");
		}
		if ("username".equals(key)) {
			return criteriaBuilder.equal(root.get("username"), value);
		}
		return null;
	}

}
