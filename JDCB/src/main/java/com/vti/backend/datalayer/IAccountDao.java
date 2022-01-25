package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountDao {
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccByUserName(String userNameLowerCase) throws SQLException;

	public int delAccByUserName(String userName) throws SQLException;

	public int createAccount(Account account) throws SQLException;

}
