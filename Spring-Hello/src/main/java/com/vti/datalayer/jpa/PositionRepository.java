package com.vti.datalayer.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;

public interface PositionRepository extends JpaRepository<Position, Integer> {

	Position findByName(PositionName eName);

}
