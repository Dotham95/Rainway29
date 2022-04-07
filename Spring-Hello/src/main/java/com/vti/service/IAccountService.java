package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;

public interface IAccountService {
	public Page<Account> getAll(Pageable pageable, AccountFillter fillter);

	public Account getAccountById(int id);

	public Account getAccountByUserName(String name);

	public Account updateAccount(int id, CreateAccountForm account);

	public Account createAccount(CreateAccountForm form);

	public void deleteAccount(int id);

	public void deleteAccounts(List<Integer> ids);

//	public boolean isAccountExistsByID(short id);
//
//	public boolean isAccountExistsByName(String username);

}
