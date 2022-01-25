package com.vti.backend.datalayer;

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

}
