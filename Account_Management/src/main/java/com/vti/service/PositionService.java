package com.vti.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.datalayer.PositionRepository;
import com.vti.entity.Position;
import com.vti.entity.filter.PositionFilter;
import com.vti.specification.PositionSpecification;
@Service
public class PositionService {
	@Autowired
	PositionRepository positionRepository;
	@Autowired
	ModelMapper modelMapper;

	public PositionService() {

	}

	public Page<Position> getAll(Pageable pageable, PositionFilter fillter) {
		Specification<Position> poSpecification = PositionSpecification.builWhere(fillter);
		return positionRepository.findAll(poSpecification, pageable);
	}
}
