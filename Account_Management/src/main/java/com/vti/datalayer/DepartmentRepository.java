package com.vti.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByName(String department);

}
