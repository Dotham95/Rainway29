package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Position;
import com.vti.entity.filter.PositionFilter;

public interface IPositionService extends UserDetailsService {
	public Page<Position> getAll(Pageable pageable, PositionFilter filter);

}
