package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.business.AccountServiceImpl;
import com.vti.backend.business.IAccountService;
import com.vti.entity.Account;

public class AccountControllerImpl implements IAccountController {

	private IAccountService accService;

	public AccountControllerImpl() {
		accService = new AccountServiceImpl();

	}

	public List<Account> getAllAccount() throws SQLException {

		return accService.getAllAccount();
	}

	public Account findAccountByUserName(String userName) throws SQLException {
		if (userName.isBlank() || userName.isEmpty()) {
			return null;
		}
		return accService.findAccByUserName(userName);
	}

	public String delAccountByUserName(String userName) throws SQLException {
		if (userName.isBlank() || userName.isEmpty()) {
			return null;
		}
		return accService.delAccByUserName(userName);
	}

	public boolean createAccount(Account account) throws SQLException {
		return accService.createAcc(account);

	}
}
