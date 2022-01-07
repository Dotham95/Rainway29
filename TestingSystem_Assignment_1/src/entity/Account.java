package entity;

import java.util.Arrays;
import java.util.Date;

public class Account {
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", department=" + department + ", position=" + position + ", createDate=" + createDate + ", groups="
				+ Arrays.toString(groups) + "]";
	}

	int id;
	String email;
	String userName;
	String fullName;
	Department department;
	Position position;
	Date createDate;
	Group[] groups;

	public Account(int id, String email, String userName, String fullName, Department department, Position position,
			Group[] groups) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.userName = userName;
		this.department = department;
		this.position = position;
		this.groups = groups;
	}

	public Account(int id, String email, String userName, String fullName, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.userName = userName;
		this.position = position;
	}

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
}
