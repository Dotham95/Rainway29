package com.vti.backend.business;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccByUserName(String userName) throws SQLException;

	public String delAccByUserName(String userName) throws SQLException;

	public boolean createAcc(Account account) throws SQLException;
}
