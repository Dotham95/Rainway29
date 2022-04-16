package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

// class sinh ra các câu điều kiện where
public class CustomAccountSpecification implements Specification<Account> {
	private String key;
	private String operator; 
	private Object value;

	public CustomAccountSpecification(String key,String operator, Object value) {
		super();
		this.key = key;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//		if ("email".equals(key)) {
//			return criteriaBuilder.like(root.get("email"), "%" + value + "%");
//		}
//		if ("userName".equals(key)) {
//			return criteriaBuilder.equal(root.get("username"), value);
//		}
//		return null;
//	}
	if (operator.equalsIgnoreCase("=")) {
		return criteriaBuilder.equal(root.<String>get(key), value.toString());
	}

	if (operator.equalsIgnoreCase(">")) {
		return criteriaBuilder.greaterThan(root.<String>get(key), value.toString());
	}

	if (operator.equalsIgnoreCase(">=")) {
		return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(key), value.toString());
	}

	if (operator.equalsIgnoreCase("<=")) {
		return criteriaBuilder.lessThanOrEqualTo(root.<String>get(key), value.toString());
	}

	if (operator.equalsIgnoreCase("LIKE")) {
		return criteriaBuilder.like(root.<String>get(key), "%" + value.toString() + "%");
	}
	return null;
}
}
