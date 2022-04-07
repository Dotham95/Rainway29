package com.vti.datalayer.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;
import com.vti.entity.enumerate.DepartmentName;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByName(String department);

}
