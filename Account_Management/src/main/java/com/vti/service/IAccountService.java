package com.vti.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.entity.filter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.entity.form.LoginForm;
import com.vti.entity.form.UpdateForm;

public interface IAccountService extends UserDetailsService {
	public Page<Account> getAll(Pageable pageable, AccountFillter filter);

	public Account getAccountById(int id);

	public Account getAccountByUserName(String name);

	public Account updateAccount(int id, UpdateForm account);

	public Account createAccount(CreateAccountForm form);

	public void deleteAccount(int id);

	public void deleteAccounts(List<Integer> ids);

	public Account login(LoginForm form) throws LoginException;

//	public boolean isAccountExistsByID(short id);
//
//	public boolean isAccountExistsByName(String username);

}
