package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Department;
import com.vti.entity.filter.DepartmentFilter;

public class DepartmentSpecification implements Specification<Department> {

	public static Specification<Department> builWhere(DepartmentFilter fillter) {
		Specification<Department> whereRoot = null;
		if (fillter.getDepartmentName() != null) {
			whereRoot = new CustomDepartmentSpecification("departmentName", fillter.getDepartmentName());
		}
		return whereRoot;
	}

	@Override
	public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return null;
	}
}
