package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.filter.DepartmentFilter;
import com.vti.entity.form.DepartmentForm;
import com.vti.service.DepartmentService;

@RestController
@RequestMapping(value = "/v2/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@Autowired
	ModelMapper modelMapper;

	public DepartmentController() {
	}

	@GetMapping
	public Page<DepartmentDTO> getAllDepartments(Pageable pageable, DepartmentFilter fillter) {

		Page<Department> entityPages = service.getAll(pageable, fillter);
		List<DepartmentDTO> listDepartmentDTOs = modelMapper.map(entityPages.getContent(),
				new TypeToken<List<DepartmentDTO>>() {
				}.getType());
		Page<DepartmentDTO> pageDepartmentDTO = new PageImpl<>(listDepartmentDTOs, pageable,
				entityPages.getTotalElements());
		return pageDepartmentDTO;
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") short id) {
		return service.getDepartmentByID(id);
	}

	@GetMapping(value = "name")
	public Department getDepartmentByName(@RequestParam(name = "name") String name) {
		return service.getDepartmentByName(name);
	}

	@PostMapping()
	public Department createDepartment(@RequestBody DepartmentForm form) {

		return service.createDepartment(form);
	}

	@PutMapping(value = "/{id}")
	public Department updateDepartment(@PathVariable(name = "id") int id, @RequestBody DepartmentForm form) {
		Department department = service.updateDepartment(id, form);
		return department;
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
	}

	@DeleteMapping
	public void deleteDepartments(@RequestParam(name = "ids") List<Integer> ids) {
		service.deleteDepartments(ids);
	}

}
