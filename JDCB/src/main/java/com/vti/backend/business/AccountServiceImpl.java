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

	public Account findAccByUserName(String userName) throws SQLException {
		// logic
		String userNameLowerCase = userName.toLowerCase().trim();

		return accountDao.findAccByUserName(userNameLowerCase);
	}

	public String delAccByUserName(String userName) throws SQLException {

		if (accountDao.delAccByUserName(userName) > 0) {
			return "Tài khoản đã xoá thành công";

		}
		return "Không tìm thấy tài khoản bạn cần xoá";

	}

	public boolean createAcc(Account account) throws SQLException {
		if (accountDao.createAccount(account) > 0) {
			return true;
		}
		return false;
	}

}
