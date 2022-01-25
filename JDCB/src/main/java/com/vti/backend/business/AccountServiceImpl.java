package com.vti.backend.business;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountDaoImpl;
import com.vti.backend.datalayer.IAccountDao;
import com.vti.entity.Account;

public class AccountServiceImpl implements IAccountService {
	private IAccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}

	public List<Account> getAllAccount() throws SQLException {

		return accountDao.getAllAccount();
	}

}
