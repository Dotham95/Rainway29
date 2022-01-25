package com.vti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	private int id;
	private String emailS;
	private String userName;

	public Account(int id, String emailS, String userName) {
		super();
		this.id = id;
		this.emailS = emailS;
		this.userName = userName;
	}

	public Account(ResultSet resultSet) throws SQLException {
		this.id = resultSet.getInt("AccountID");
		this.emailS = resultSet.getString("Email");
		this.userName = resultSet.getString("Username");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailS() {
		return emailS;
	}

	public void setEmailS(String emailS) {
		this.emailS = emailS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", emailS=" + emailS + ", userName=" + userName + "]";
	}
}
