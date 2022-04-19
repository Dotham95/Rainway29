package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.PositionDTO;
import com.vti.entity.Position;
import com.vti.entity.filter.PositionFilter;
import com.vti.service.PositionService;

@RestController
@RequestMapping(value = "/v2/api/positions")
public class PositionController {
	@Autowired
	private PositionService service;

	@Autowired
	ModelMapper modelMapper;

	public PositionController() {
	}

	@GetMapping
	public Page<PositionDTO> getAllPositions(Pageable pageable, PositionFilter fillter) {

		Page<Position> entityPages = service.getAll(pageable, fillter);
		List<PositionDTO> listPositionDTOs = modelMapper.map(entityPages.getContent(),
				new TypeToken<List<PositionDTO>>() {
				}.getType());
		Page<PositionDTO> pagePositionDTO = new PageImpl<>(listPositionDTOs, pageable,
				entityPages.getTotalElements());
		return pagePositionDTO;
	}
}
