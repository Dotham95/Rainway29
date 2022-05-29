package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.dto.DepartmentDTO;

@Entity
@Table(name = "Account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {
	// đánh dấu version
	private static final long serialVersionUID = 1L;
	// để short thì truyền dữ liệu vào phải ép kiểu.
	@Column(name = "AccountID")
	@Id
	// đại diện cho tự động tăng
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "FullName", length = 50, nullable = false)
	private String fullName;

	@Column(name = "Username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "Email", length = 50, nullable = false, unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
	private Position position;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date CreateDate;

	public Employee() {
		super();
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email;
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", fullName=" + fullName + ", username=" + username + ", email=" + email
				+ ", department=" + department + ", position=" + position + ", CreateDate=" + CreateDate + "]";
	}

}
