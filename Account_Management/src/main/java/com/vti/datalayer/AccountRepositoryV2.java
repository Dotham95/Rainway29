package com.vti.datalayer;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Account;

@Repository
@Primary
public interface AccountRepositoryV2 extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

	public Page<Account> findAllByUsernameOrEmail(Pageable pageable, String userName, String email);

	public Account findByUsername(String username);

	@Modifying
	@Transactional
	@Query("DELETE FROM Account WHERE id IN(:ids)")
	public void deleteByIds(@Param("ids") List<Integer> ids);

//	public boolean existsById(short id);
//
//	public boolean existsByUserName(String username);
}



