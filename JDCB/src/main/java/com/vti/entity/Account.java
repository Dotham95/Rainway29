package com.vti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.utils.ScannerUtil;

public class Account {
	private int id;
	private String emailS;
	private String userName;
	private String fullName;

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
		this.fullName = resultSet.getString("FullName");
	}

	public Account() {
		super();
	}

	public void scanInfo() {

		System.out.println("Mời bạn nhập vào Email cần tạo");
		this.emailS = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào UserName cần tạo");
		this.userName = ScannerUtil.scanStr();
		System.out.println("Mời bạn nhập vào FullName cần tạo");
		this.fullName = ScannerUtil.scanStr();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String table() {
		return String.format("%3d  |%30s  |%10s  |%15s", id, emailS, userName, fullName);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", emailS=" + emailS + ", userName=" + userName + ", fullName=" + fullName + "]";
	}

}
