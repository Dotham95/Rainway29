package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Employee;
import com.vti.entity.fillter.EmployeeFilter;
import com.vti.utils.Utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class EmployeeSpecifition {
	@SuppressWarnings("deprecation")
	public static Specification<Employee> builWhere(String search,EmployeeFilter filter) {
		Specification<Employee> where = null;

		if (!StringUtils.isEmpty(search)) {

			search = Utils.formatSearch(search);

			CustomSpecification username = new CustomSpecification("username", search);
			CustomSpecification fullname = new CustomSpecification("fullname", search);
			where = Specification.where(username).or(fullname);
		}

		// if there is filter by Role
//		if (filter != null && filter.getRole() != null) {
//			CustomSpecification role = new CustomSpecification("role", filter.getRole());
//			if (where == null) {
//				where = role;
//			} else {
//				where = where.and(role);
//			}
//		}
//
//		// if there is filter by department name
//		if (filter != null && filter.getDepartmentName() != null) {
//			CustomSpecification departmentName = new CustomSpecification("departmentName",
//					filter.getDepartmentName());
//			if (where == null) {
//				where = departmentName;
//			} else {
//				where = where.and(departmentName);
//			}
//		}

		return where;
	}
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Employee> {

	@NonNull
	private String field;
	@NonNull
	private Object value;

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (field.equalsIgnoreCase("username")) {
			return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
		}

		if (field.equalsIgnoreCase("fullname")) {
			return criteriaBuilder.like(root.get("fullname"), "%" + value.toString() + "%");
		}

//		if (field.equalsIgnoreCase("role")) {
//			return criteriaBuilder.equal(root.get("role"), value);
//		}
//
//		if (field.equalsIgnoreCase("departmentName")) {
//			return criteriaBuilder.equal(root.get("department").get("name"), value.toString());
//		}

		return null;
	}
}

