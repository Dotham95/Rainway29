package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.utils.JDCBUtil;

public class AccountDaoImpl implements IAccountDao {

	public List<Account> getAllAccount() throws SQLException {

		List<Account> list = new ArrayList<Account>();

		String query = "SELECT * FROM Account";
		ResultSet resultSet = JDCBUtil.getIntance().getStatement().executeQuery(query);

		while (resultSet.next()) {
			// Account newAccount = new Account(resultSet);
			list.add(new Account(resultSet));

		}
		return list;
	}

	public Account findAccByUserName(String userNameLowerCase) throws SQLException {
//		Account account = null;

		String queString = "SELECT * FROM Account WHERE userName = '" + userNameLowerCase + "'";

		ResultSet resultSet = JDCBUtil.getIntance().getStatement().executeQuery(queString);
		if (resultSet.next()) {
			return new Account(resultSet);
		}

		return null;
	}

	public int delAccByUserName(String userName) throws SQLException {
		String queString = "DELETE FROM Account WHERE userName = '" + userName + "'";

		Integer count = JDCBUtil.getIntance().getStatement().executeUpdate(queString);

		return count;
	}

	public int createAccount(Account account) throws SQLException {
		String queryString = "Insert into Account (`Email`, `Username`, `Fullname`) Values (?, ?, ?) ";
		PreparedStatement preparedStatement = JDCBUtil.getIntance().getPreparedStatement(queryString);

		preparedStatement.setString(1, account.getEmailS());
		preparedStatement.setString(2, account.getUserName());
		preparedStatement.setString(3, account.getFullName());
		return preparedStatement.executeUpdate();
	}

}
