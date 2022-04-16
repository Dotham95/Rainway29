package com.vti.service;

import java.util.Collections;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.vti.datalayer.AccountRepositoryV2;
import com.vti.datalayer.DepartmentRepository;
import com.vti.datalayer.PositionRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import com.vti.entity.filter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.entity.form.LoginForm;
import com.vti.entity.form.UpdateForm;
//import com.vti.specification.AccountSpecification;
import com.vti.specification.CustomAccountSpecification;

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

//	@Override
//	public Page<Account> getAll(Pageable pageable, AccountFillter fillter) {
//		Specification<Account> aSpecification = AccountSpecification.builWhere(fillter);
//		return repository.findAll(aSpecification, pageable);
//	}
	@SuppressWarnings("deprecation")
	public Page<Account> getAll(Pageable pageable, AccountFillter filter, String search) {

//		Specification<Account> where = null;
//
//		if (!StringUtils.isEmpty(search)) {
//			CustomAccountSpecification emailSpecification = new CustomAccountSpecification("email", "LIKE", search);
//			CustomAccountSpecification usernameSpecification = new CustomAccountSpecification("username", "LIKE", search);
//			where = Specification.where(emailSpecification).or(usernameSpecification);
//		}
//
//		return repository.findAll(where, pageable);
//	}
		CustomAccountSpecification minIdSpecification = new CustomAccountSpecification("id", ">=", filter.getMinID());

		CustomAccountSpecification maxIdSpecification = new CustomAccountSpecification("id", "<=", filter.getMaxID());

		CustomAccountSpecification searchSpecification = new CustomAccountSpecification("username", "LIKE", search);

//	CustomAccountSpecification searchSpecification = new CustomAccountSpecification("email", "LIKE", search);

		Specification<Account> where = null;

		if (filter.getMinID() != 0) {
			where = minIdSpecification;
		}

		if (filter.getMaxID() != 0) {
			if (where == null) {
				where = maxIdSpecification;
			} else {
				where = where.and(maxIdSpecification);
			}
		}

		if (!StringUtils.isEmpty(search)) {
			if (where == null) {
				where = searchSpecification;
			} else {
				where = where.and(searchSpecification);
			}
		}

		return repository.findAll(where, pageable);
	}

	@Override
	public Account getAccountById(int id) {

		return repository.findById(id).get();
	}

	@Override
	public Account createAccount(CreateAccountForm form) {
		Account account2 = new Account();
		account2.setFullName(form.getFullName());
		account2.setEmail(form.getEmail());
		account2.setUsername(form.getUsername());
		account2.setRole(form.getRole());
//		account2.setPassword(form.getPassword());
		Department department = dRepository.findById(form.getDepartmentId()).get();
		account2.setDepartment(department);
		Position position = poRepository.findById(form.getPositionId()).get();
		account2.setPosition(position);
		return repository.save(account2);

	}

	@Override
	public Account updateAccount(int id, UpdateForm form) {

		Account account2 = repository.findById(id).get();
		account2.setFullName(form.getFullName());
		account2.setEmail(form.getEmail());
		account2.setUsername(form.getUsername());
//		account2.setRole(form.getRole();
//		account2.setPassword(form.getPassword());
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("Không tìm thấy account");
		}
		UserDetails userDetails = new User(account.getUsername(), account.getPassword(),
				AuthorityUtils.createAuthorityList(account.getRole()));
		return userDetails;
	}

	@Override
	public Account getAccountByUserName(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Account login(LoginForm form) throws LoginException {
		Account account = repository.findByUsername(form.getUsername());
		if (account == null) {
			throw new LoginException("Username không chính xác");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean check = encoder.matches(form.getPassword(), account.getPassword());
		if (check) {
			return account;
		}
		throw new LoginException("Password không chính xác");

	}
}
