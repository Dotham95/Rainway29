package com.vti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.datalayer.jpa.AccountRepositoryV2;
import com.vti.datalayer.jpa.DepartmentRepository;
import com.vti.datalayer.jpa.PositionRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.specification.AccountSpecification;

@Service
@Transactional
public class AccountService implements IAccountService {
	@Autowired
	AccountRepositoryV2 repository;

	@Autowired
	PositionRepository poRepository;

	@Autowired
	DepartmentRepository dRepository;

	@Autowired
	ModelMapper modelMapper;

	public AccountService() {

	}

	@Override
	public Page<Account> getAll(Pageable pageable, AccountFillter fillter) {
		Specification<Account> aSpecification = AccountSpecification.builWhere(fillter);
		return repository.findAll(aSpecification, pageable);
	}

	@Override
	public Account getAccountById(int id) {

		return repository.findById(id).get();
	}

	@Override
	public Account getAccountByUserName(String name) {
		return repository.findByUsername(name);
	}

	@Override
	public Account createAccount(CreateAccountForm form) {
		Account account2 = new Account();
		account2.setFullName(form.getFullName());
		account2.setEmail(form.getEmail());
		account2.setUsername(form.getUsername());
		Department department = dRepository.findById(form.getDepartmentId()).get();
		account2.setDepartment(department);
		Position position = poRepository.findById(form.getPositionId()).get();
		account2.setPosition(position);
		return repository.save(account2);

	}

	@Override
	public Account updateAccount(int id, CreateAccountForm form) {

		Account account2 = repository.findById(id).get();
		account2.setFullName(form.getFullName());
		account2.setEmail(form.getEmail());
		account2.setUsername(form.getUsername());
		Department department = dRepository.findById(form.getDepartmentId()).get();
		account2.setDepartment(department);
		Position position = poRepository.findById(form.getPositionId()).get();
		account2.setPosition(position);
		return repository.save(account2);
	}

	@Override
	public void deleteAccount(int id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAccounts(List<Integer> ids) {
		repository.deleteByIds(ids);
	}
//	public boolean isAccountExistsByID(short id) {
//		return repository.existsById(id);
//	}
//
//	public boolean isAccountExistsByName(String username) {
//		return repository.existsByUserName(username);
//	}
}
