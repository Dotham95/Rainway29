package entity;

import java.util.Date;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public Date createDate;
	public Account[] accounts;

	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Group(int id, String name, Account[] accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}

	public Group() {
		super();
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date i) {
		this.createDate = i;
	}

	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate + "]";
	}
}