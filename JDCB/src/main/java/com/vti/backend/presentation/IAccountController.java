package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountController {
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccountByUserName(String userName) throws SQLException;

	public String delAccountByUserName(String userName) throws SQLException;

	public boolean createAccount(Account account) throws SQLException;
}
