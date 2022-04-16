package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "Username")
	private String username;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "Role")
	private String role;
	
	@Column(name = "Password")
	private String password;

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

	@Override
	public String toString() {
		return "Account [id=" + id + ", fullName=" + fullName + ", username=" + username + ", email=" + email
				+ ", department=" + department + ", position=" + position + ", CreateDate=" + CreateDate + "]";
	}

}
