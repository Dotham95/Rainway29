package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Position;
import com.vti.entity.filter.PositionFilter;

public class PositionSpecification implements Specification<Position> {
	public static Specification<Position> builWhere(PositionFilter fillter) {
		Specification<Position> whereRoot = null;
		if (fillter.getPositionName() != null) {
			whereRoot = new CustomPositionSpecification("posiitonName", fillter.getPositionName());
		}
		return whereRoot;
	}

	@Override
	public Predicate toPredicate(Root<Position> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

}
