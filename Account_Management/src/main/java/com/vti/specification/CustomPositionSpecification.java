package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Position;

public class CustomPositionSpecification implements Specification<Position> {
	private String key;
	private String value;

	public CustomPositionSpecification(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Position> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if ("positionName".equals(key)) {
			return criteriaBuilder.like(root.get("positionName"), "%" + value + "%");
		}
		return null;
	}

}
