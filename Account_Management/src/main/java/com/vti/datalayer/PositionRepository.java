package com.vti.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;

public interface PositionRepository extends JpaRepository<Position, Integer>, JpaSpecificationExecutor<Position> {

	Position findByName(PositionName eName);

}
